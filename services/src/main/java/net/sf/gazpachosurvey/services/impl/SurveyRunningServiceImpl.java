package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.SurveyLink;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.repository.SurveyLinkRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.services.SurveyRunningService;
import net.sf.gazpachosurvey.types.InvitationStatus;
import net.sf.gazpachosurvey.types.SurveyRunningType;
import net.sf.gazpachosurvey.util.RandomTokenGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyRunningServiceImpl extends AbstractPersistenceService<SurveyRunning, SurveyRunningDTO> implements
        SurveyRunningService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @Autowired
    private SurveyLinkRepository surveyLinkRepository;

    @Autowired
    public SurveyRunningServiceImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }

    @Override
    public SurveyRunningDTO save(SurveyRunningDTO dto) {
        SurveyRunning running = mapper.map(dto, SurveyRunning.class);

        if (SurveyRunningType.BY_INVITATION.equals(running.getType())) {
            for (Participant participant : running.getParticipants()) {
                participantRepository.save(participant);
            }
            running = repository.save(running);

            for (int idx = 0; idx < running.getParticipants().size(); idx++) {
                SurveyLink surveyLink = new SurveyLink();
                surveyLink.setSurveyRunning(running);
                surveyLink.setToken(tokenGenerator.generate());
                surveyLink.setStatus(InvitationStatus.ACTIVE);
                surveyLinkRepository.save(surveyLink);
            }
        }

        return mapper.map(running, dtoClazz);
    }

}

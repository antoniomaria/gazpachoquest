package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.services.SurveyRunningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyRunningServiceImpl extends
        AbstractPersistenceService<SurveyRunning, SurveyRunningDTO, Integer>
        implements SurveyRunningService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    public SurveyRunningServiceImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }

    @Override
    public Integer add(SurveyRunningDTO dto) {
        SurveyRunning running = mapper.map(dto, SurveyRunning.class);

        for (Participant participant : running.getParticipants()) {
            participantRepository.save(participant);
        }
        running = repository.save(running);
        return running.getId();
    }

 

}

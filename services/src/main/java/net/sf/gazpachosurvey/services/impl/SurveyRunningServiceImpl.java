package net.sf.gazpachosurvey.services.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyLink;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.repository.SurveyLinkRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.services.SurveyRunningService;
import net.sf.gazpachosurvey.types.InvitationStatus;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;
import net.sf.gazpachosurvey.types.SurveyRunningType;
import net.sf.gazpachosurvey.util.RandomTokenGenerator;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

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
    VelocityEngineFactoryBean velocityFactory;
    
    @Autowired
    public SurveyRunningServiceImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }

    @Override
    public SurveyRunningDTO save(SurveyRunningDTO dto) {
        Assert.notNull(dto.getSurvey(), "Survey is required");
        SurveyRunning running = mapper.map(dto, SurveyRunning.class);

        if (SurveyRunningType.BY_INVITATION.equals(running.getType())) {
            
Survey survey = surveyRepository.findOne(running.getSurvey().getId());
            
            Map<MailMessageTemplateType, MailMessageTemplate> templates = survey.getMailTemplates();
            MailMessageTemplate invitationTemplate = templates.get(MailMessageTemplateType.INVITATION);
           
            VelocityEngine velocityEngine = velocityFactory.getObject();
            
            for (Participant participant : running.getParticipants()) {
                Map<String, Object> model = new HashMap<>();
                model.put("lastname", participant.getLastname());
                Language preferedLanguage = participant.getPreferedLanguage();
                
                StringBuilder templateId = new StringBuilder().append(invitationTemplate.getId()) ;
                if (preferedLanguage != null){
                    templateId.append("/");
                    templateId.append(preferedLanguage);
                }
                String result = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, templateId.toString(), "UTF-8", model);

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

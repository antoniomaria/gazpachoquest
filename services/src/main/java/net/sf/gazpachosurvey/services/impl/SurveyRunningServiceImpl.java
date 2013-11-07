package net.sf.gazpachosurvey.services.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachosurvey.domain.core.MailMessage;
import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
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
public class SurveyRunningServiceImpl extends
        AbstractPersistenceService<SurveyRunning, SurveyRunningDTO> implements
        SurveyRunningService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private VelocityEngineFactoryBean velocityFactory;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    public SurveyRunningServiceImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }

    @Override
    public SurveyRunningDTO save(SurveyRunningDTO dto) {
        Assert.notNull(dto.getSurvey(), "Survey is required");
        SurveyRunning running = mapper.map(dto, SurveyRunning.class);

        if (SurveyRunningType.BY_INVITATION.equals(running.getType())) {

            Survey survey = surveyRepository.findOne(running.getSurvey()
                    .getId());

            Map<MailMessageTemplateType, MailMessageTemplate> templates = survey
                    .getMailTemplates();
            MailMessageTemplate invitationTemplate = templates
                    .get(MailMessageTemplateType.INVITATION);

            for (Participant participant : running.getParticipants()) {
                participantRepository.save(participant);
            }
            running = repository.save(running);
            // Running entity must be persisted before creating PersonalInvitation
            for (Participant participant : running.getParticipants()) {
                String token = tokenGenerator.generate();
                PersonalInvitation personalInvitation = PersonalInvitation.with()
                        .surveyRunning(running).token(token)
                        .status(InvitationStatus.ACTIVE)
                        .build();
                
                invitationRepository.save(personalInvitation);
                MailMessage mailMessage = composeMailMessage(
                        invitationTemplate, participant, token);
                mailMessageRepository.save(mailMessage);
            }

        }
        return mapper.map(running, dtoClazz);
    }

    private MailMessage composeMailMessage(
            MailMessageTemplate mailMessageTemplate, Participant participant,
            String surveyLinkToken) {

        Map<String, Object> model = new HashMap<>();
        model.put("lastname", participant.getLastname());
        model.put("firstname", participant.getFirstname());
        model.put("gender", participant.getGender());
        model.put("link", "http://localhost:8080/questionaires-ui/token="
                + surveyLinkToken);

        Language preferedLanguage = participant.getPreferedLanguage();

        StringBuilder templateLocation = new StringBuilder()
                .append(mailMessageTemplate.getId());
        if (preferedLanguage != null) {
            templateLocation.append("/");
            templateLocation.append(preferedLanguage);
        }
        VelocityEngine velocityEngine = velocityFactory.getObject();

        String body = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, templateLocation.toString(), "UTF-8", model);

        MailMessageTemplateLanguageSettings languageSettings = mailMessageTemplate
                .getLanguageSettings();
        if (preferedLanguage != null
                && !preferedLanguage.equals(mailMessageTemplate.getLanguage())) {
            MailMessageTemplateTranslation preferedTranslation = mailMessageTemplate
                    .getTranslations().get(preferedLanguage);
            if (preferedTranslation != null) {
                languageSettings = preferedTranslation.getLanguageSettings();
            }
        }
        MailMessage mailMessage = MailMessage.with()
                .subject(languageSettings.getSubject())
                .to(participant.getEmail())
                .replyTo(mailMessageTemplate.getReplyTo())
                .from(mailMessageTemplate.getFromAddress()).text(body).build();
        return mailMessage;
    }

}

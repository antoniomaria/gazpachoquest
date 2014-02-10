package net.sf.gazpachosurvey.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.gazpachosurvey.domain.core.MailMessage;
import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.repository.StudyRepository;
import net.sf.gazpachosurvey.services.StudyService;
import net.sf.gazpachosurvey.types.EntityStatus;
import net.sf.gazpachosurvey.types.InvitationStatus;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;
import net.sf.gazpachosurvey.types.StudyAccessType;
import net.sf.gazpachosurvey.util.RandomTokenGenerator;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

@Service
public class StudyServiceImpl extends AbstractPersistenceService<Study> implements StudyService {

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @Autowired
    private VelocityEngineFactoryBean velocityFactory;

    @Autowired
    public StudyServiceImpl(final StudyRepository repository) {
        super(repository);
    }

    @Override
    public Study save(Study study) {
        Study existing = null;
        if (study.isNew()) {
            existing = repository.save(study);
        } else {
            existing = repository.findOne(study.getId());
            existing.setStartDate(study.getStartDate());
            existing.setExpirationDate(study.getExpirationDate());
        }
        return existing;
    }

    @Override
    public Study save(Study study, Set<QuestionnairDefinition> questionnairDefinitions, Set<Participant> participants) {
        if (StudyAccessType.BY_INVITATION.equals(study.getType())) {
            study = this.save(study);
            for (QuestionnairDefinition questionnairDefinition : questionnairDefinitions) {

                questionnairDefinition = questionnairDefinitionRepository.findOne(questionnairDefinition.getId());

                Map<MailMessageTemplateType, MailMessageTemplate> templates = questionnairDefinition.getMailTemplates();
                MailMessageTemplate invitationTemplate = templates.get(MailMessageTemplateType.INVITATION);
                for (Participant participant : participants) {
                    Assert.state(!participant.isNew(), "Persist all participant before starting a study.");
                    Questionnair questionnair = Questionnair.with().status(EntityStatus.CONFIRMED).study(study)
                            .questionnairDefinition(questionnairDefinition).participant(participant).build();
                    questionnairRepository.save(questionnair);

                    String token = tokenGenerator.generate();

                    PersonalInvitation personalInvitation = PersonalInvitation.with().study(study).token(token)
                            .status(InvitationStatus.ACTIVE).participant(participant).build();
                    invitationRepository.save(personalInvitation);

                    MailMessage mailMessage = composeMailMessage(invitationTemplate, participant, token);
                    mailMessageRepository.save(mailMessage);
                }
            }
        }
        return study;
    }

    private MailMessage composeMailMessage(final MailMessageTemplate mailMessageTemplate,
            final Participant participant, final String surveyLinkToken) {

        Map<String, Object> model = new HashMap<>();
        model.put("lastname", StringUtils.defaultIfBlank(participant.getLastname(), ""));
        model.put("firstname", StringUtils.defaultIfBlank(participant.getFirstname(), ""));
        model.put("gender", participant.getGender());
        model.put("link", "http://localhost:8080/questionaires-ui/token=" + surveyLinkToken);

        Language preferedLanguage = participant.getPreferedLanguage();

        StringBuilder templateLocation = new StringBuilder().append(mailMessageTemplate.getId());
        if (preferedLanguage != null) {
            templateLocation.append("/");
            templateLocation.append(preferedLanguage);
        }
        VelocityEngine velocityEngine = velocityFactory.getObject();

        String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation.toString(), "UTF-8",
                model);

        MailMessageTemplateLanguageSettings languageSettings = mailMessageTemplate.getLanguageSettings();
        if (preferedLanguage != null && !preferedLanguage.equals(mailMessageTemplate.getLanguage())) {
            MailMessageTemplateTranslation preferedTranslation = mailMessageTemplate.getTranslations().get(
                    preferedLanguage);
            if (preferedTranslation != null) {
                languageSettings = preferedTranslation.getLanguageSettings();
            }
        }
        MailMessage mailMessage = MailMessage.with().subject(languageSettings.getSubject()).to(participant.getEmail())
                .replyTo(mailMessageTemplate.getReplyTo()).from(mailMessageTemplate.getFromAddress()).text(body)
                .build();
        return mailMessage;
    }

}

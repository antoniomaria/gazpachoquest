package net.sf.gazpachoquest.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.MailMessage;
import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.Participant;
import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.ParticipantRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.repository.StudyRepository;
import net.sf.gazpachoquest.services.StudyService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.InvitationStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.StudyAccessType;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = false)
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
    @Transactional(readOnly = false)
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

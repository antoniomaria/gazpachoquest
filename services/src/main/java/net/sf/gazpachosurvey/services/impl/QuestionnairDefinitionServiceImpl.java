package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionnairDefinitionTranslationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.services.QuestionnairDefinitionService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnairDefinitionServiceImpl extends
        AbstractLocalizedPersistenceService<QuestionnairDefinition, QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> implements QuestionnairDefinitionService {

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    private QuestionnairDefinitionTranslationRepository questionnairDefinitionTranslationRepository;

    @Autowired
    public QuestionnairDefinitionServiceImpl(final QuestionnairDefinitionRepository questionnairDefinitionRepository,
            final QuestionnairDefinitionTranslationRepository translationRepository) {
        super(questionnairDefinitionRepository, translationRepository, new QuestionnairDefinitionTranslation.Builder());
    }

    @Override
    public QuestionnairDefinition confirm(final QuestionnairDefinition questionnairDefinition) {
        QuestionnairDefinition entity = repository.findOne(questionnairDefinition.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            questionnairAnswersRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return questionnairDefinition;
    }

    @Override
    public long questionGroupsCount(final Integer surveyId) {
        return questionGroupRepository.countByExample(QuestionGroup.with().questionnairDefinition(QuestionnairDefinition.with().id(surveyId).build())
                .build(), new SearchParameters());
    }

    @Override
    public QuestionnairDefinition save(final QuestionnairDefinition questionnairDefinition) {
        QuestionnairDefinition existing = null;
        if (questionnairDefinition.isNew()) {
            questionnairDefinition.setStatus(EntityStatus.DRAFT);
            existing = repository.save(questionnairDefinition);
        } else {
            existing = repository.findOne(questionnairDefinition.getId());
            existing.setLanguage(questionnairDefinition.getLanguage());
            existing.setLanguageSettings(questionnairDefinition.getLanguageSettings());
            for (QuestionGroup questionGroup : questionnairDefinition.getQuestionGroups()) {
                if (!questionGroup.isNew()) {
                    continue;
                }
                existing.addQuestionGroup(questionGroup);
            }
        }
        return existing;
    }
}

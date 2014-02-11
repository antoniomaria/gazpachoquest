package net.sf.gazpachosurvey.services.impl;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionGroupTranslationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.services.QuestionGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionGroupServiceImpl extends
        AbstractLocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings>
        implements QuestionGroupService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Autowired
    public QuestionGroupServiceImpl(final QuestionGroupRepository repository,
            final QuestionGroupTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionGroupTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionGroup> findByQuestionnairDefinitionId(final Integer surveyId) {
        return ((QuestionGroupRepository) repository).findByQuestionnairDefinitionId(surveyId);
    }

    @Override
    @Transactional(readOnly = true)
    public QuestionGroup findOneByPositionInQuestionnairDefinition(final Integer surveyId, final Integer position) {
        return ((QuestionGroupRepository) repository).findOneByPositionInQuestionnairDefinition(surveyId, position);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findPositionInSurvey(final Integer questionGroupId) {
        return ((QuestionGroupRepository) repository).findPositionInQuestionnairDefinition(questionGroupId);
    }

    @Override
    @Transactional(readOnly = true)
    public long questionsCount(final Integer questionGroupId) {
        return questionRepository.countByExample(
                Question.with().questionGroup(QuestionGroup.with().id(questionGroupId).build()).build(),
                new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionGroup save(final QuestionGroup questionGroup) {
        Assert.state(!questionGroup.isNew(),
                "QuestionGroup must be already persisted. Try by adding to QuestionnairDefinition first.");

        QuestionGroup existing = repository.findOne(questionGroup.getId());

        for (Question question : questionGroup.getQuestions()) {
            if (!question.isNew()) {
                continue;
            }
            if (question.getLanguage() == null) {
                question.setLanguage(questionGroup.getLanguage());
            }
            for (Question subquestion : question.getSubquestions()) {
                if (subquestion.getLanguage() == null) {
                    subquestion.setLanguage(question.getLanguage());
                }
            }
            existing.addQuestion(question);
        }
        return existing;
    }
}

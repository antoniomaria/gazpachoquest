package net.sf.gazpachosurvey.services.impl;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionGroupTranslationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.services.QuestionGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class QuestionGroupServiceImpl extends
        AbstractLocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings>
        implements QuestionGroupService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionGroupServiceImpl(QuestionGroupRepository repository,
            QuestionGroupTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionGroupTranslation.Builder());
    }

    @Override
    public QuestionGroup save(QuestionGroup questionGroup) {
        Assert.state(!questionGroup.isNew(), "QuestionGroup must be already persisted. Try by adding to Survey first.");

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

    @Override
    public Integer findPositionInSurvey(Integer questionGroupId) {
        return ((QuestionGroupRepository) repository).findPositionInSurvey(questionGroupId);
    }

    @Override
    public QuestionGroup findOneByPositionInSurvey(Integer surveyId, Integer position) {
        return ((QuestionGroupRepository) repository).findOneByPositionInSurvey(surveyId, position);
    }

    @Override
    public List<QuestionGroup> findBySurveyId(Integer surveyId) {
        return ((QuestionGroupRepository) repository).findBySurveyId(surveyId);
    }

    @Override
    public long questionsCount(Integer questionGroupId) {
        return questionRepository.countByExample(
                Question.with().questionGroup(QuestionGroup.with().id(questionGroupId).build()).build(),
                new SearchParameters());
    }
}

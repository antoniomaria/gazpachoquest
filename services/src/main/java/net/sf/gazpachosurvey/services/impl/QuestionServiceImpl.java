package net.sf.gazpachosurvey.services.impl;

import javax.annotation.Resource;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionTranslationRepository;
import net.sf.gazpachosurvey.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class QuestionServiceImpl extends
        AbstractLocalizedPersistenceService<Question, QuestionTranslation, QuestionLanguageSettings> implements
        QuestionService {

    @Resource
    private SurveyRepository surveyRepository;

    @Resource
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository, QuestionTranslationRepository translationRepository) {
        super(repository, translationRepository);
    }

    @Override
    public Question save(Question question) {
        Assert.state(!question.isNew(), "Question must be already persisted. Try by adding to QuestionGroup or as added as subquestion first.");
        Question existing = repository.save(question);
        for (Question subquestion : question.getSubquestions()) {
            if (!subquestion.isNew()) { // Skip created subquestions
                continue;
            }
            existing.addSubquestion(subquestion);
        }

        for (QuestionOption questionOption : question.getQuestionOptions()) {
            if (!questionOption.isNew()) { // Skip created questionOptions
                continue;
            }
            existing.addQuestionOption(questionOption);
        }
        return existing;
    }

}

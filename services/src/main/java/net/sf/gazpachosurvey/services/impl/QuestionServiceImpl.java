package net.sf.gazpachosurvey.services.impl;

import javax.annotation.Resource;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionTranslationRepository;
import net.sf.gazpachosurvey.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl
        extends
        AbstractLocalizedPersistenceService<Question, QuestionDTO, QuestionTranslation, QuestionLanguageSettings, QuestionLanguageSettingsDTO>
        implements QuestionService {

    @Resource
    private SurveyRepository surveyRepository;

    @Resource
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository, QuestionTranslationRepository translationRepository) {
        super(repository, translationRepository, Question.class, QuestionDTO.class, QuestionTranslation.class,
                QuestionLanguageSettings.class, QuestionLanguageSettingsDTO.class, new QuestionTranslation.Builder());
    }

    @Override
    public Integer addQuestion(Integer pageId, QuestionDTO question) {
        QuestionGroup questionGroup = questionGroupRepository.findOne(pageId);
        Survey survey = questionGroup.getSurvey();
        Question questionEntity = mapper.map(question, Question.class);
        questionEntity.setSurvey(survey);
        questionEntity.setQuestionGroup(questionGroup);
        questionEntity.setLanguage(survey.getLanguage());
        questionGroup.addQuestion(questionEntity);
        questionGroup = questionGroupRepository.save(questionGroup);
        return questionGroup.getQuestions().get(questionGroup.getQuestions().size() - 1).getId();
    }

}

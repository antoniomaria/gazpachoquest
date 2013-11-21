package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/datasource-context.xml" })
/*
 * @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
 * DirtiesContextTestExecutionListener.class,
 * TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class
 * })
 * 
 * @DatabaseSetup("SurveyRepository-dataset.xml")
 */
public class SurveyOrderingRepositoryTest {

    @Autowired
    private SurveyRepository repository;


    @Autowired
    private QuestionGroupRepository questionGroupRepository;
    
    @Test
    public void saveSurvey() {
        Language d;
        SurveyLanguageSettings settings = SurveyLanguageSettings.with()
                .title("example 1").description("description 1").build();
        Survey survey = Survey.with().language(Language.ES)
                .languageSettings(settings).build();
        repository.save(survey);
        Question question = new Question();
        question.setLanguage(Language.ES);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("mi pregunta 1");
        question.setLanguageSettings(questionLanguageSettings);

        question = new Question();
        question.setLanguage(Language.ES);
        questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("mi pregunta 2");
        question.setLanguageSettings(questionLanguageSettings);

        repository.save(survey);
        System.out.println("fin");
    }
    

    @Test
    public void saveSurveyWithQuestionGroups() {
        SurveyLanguageSettings settings = SurveyLanguageSettings.with()
                .title("example 2").description("description 2").build();
        Survey survey = Survey.with().language(Language.ES)
                .languageSettings(settings).build();
        QuestionGroup questionGroup = new QuestionGroup();
        questionGroup.setLanguage(Language.ES);
        QuestionGroupLanguageSettings groupSettings = new QuestionGroupLanguageSettings();
        groupSettings.setTitle("Grupo  1");
        questionGroup.setLanguageSettings(groupSettings);
        
        survey.addQuestionGroup(questionGroup);
        
        repository.save(survey);
        
        Question question = new Question();
        question.setLanguage(Language.ES);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("mi pregunta 1");
        question.setLanguageSettings(questionLanguageSettings);
        
        questionGroup.addQuestion(question);

        question = new Question();
        question.setLanguage(Language.ES);
        questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("mi pregunta 2");
        question.setLanguageSettings(questionLanguageSettings);
        
        questionGroup.addQuestion(question);
        
        repository.save(survey);
        System.out.println("fin");
    }

    @Test
    public void addQuestion() {
        Survey survey = repository.findOne(301);
        Question question = new Question();
        question.setLanguage(Language.ES);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("mi pregunta 0");
        question.setLanguageSettings(questionLanguageSettings);
        repository.save(survey);
        System.out.println("fin");
    }


}

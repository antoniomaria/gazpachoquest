package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

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
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepository-dataset.xml")
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository repository;

    @Test
    public void saveTest() {
        SurveyLanguageSettings languageSettings = SurveyLanguageSettings.with().title("My Survey").build();
        Survey survey = Survey.with().language(Language.EN).languageSettings(languageSettings).build();
        survey = repository.save(survey);
        assertThat(survey.getCreatedDate()).isNotNull();
        assertThat(survey.getCreatedBy()).isNotNull();

        languageSettings = SurveyLanguageSettings.with().title("My Survey. Version 1").build();
        survey.setLanguageSettings(languageSettings);
        survey = repository.save(survey);
        assertThat(survey.getLastModifiedBy()).isNotNull();
        assertThat(survey.getLastModifiedDate()).isNotNull();
    }


    @Test
    public void saveSurveyWithQuestionGroups() {
        SurveyLanguageSettings settings = SurveyLanguageSettings.with().title("My Survey example").description("My survey description")
                .build();
        Survey survey = Survey.with().language(Language.ES).languageSettings(settings).build();
        QuestionGroup questionGroup = new QuestionGroup();
        questionGroup.setLanguage(Language.ES);
        QuestionGroupLanguageSettings groupSettings = new QuestionGroupLanguageSettings();
        groupSettings.setTitle("Group 1");
        questionGroup.setLanguageSettings(groupSettings);

        survey.addQuestionGroup(questionGroup);

        repository.save(survey);

        Question question = new Question();
        question.setLanguage(Language.ES);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 1");
        question.setLanguageSettings(questionLanguageSettings);

        questionGroup.addQuestion(question);

        question = new Question();
        question.setLanguage(Language.ES);
        questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 2");
        question.setLanguageSettings(questionLanguageSettings);

        questionGroup.addQuestion(question);

        survey = repository.save(survey);
        
        Survey fetched = repository.findOne(survey.getId());
        assertThat(fetched.getQuestionGroups()).hasSize(1);
        assertThat(fetched.getQuestionGroups().get(0).getQuestions()).hasSize(2);
    }

    
    @Test
    public void findOne() {
        int surveyId = 2;
        Survey survey = repository.findOne(surveyId);
        List<QuestionGroup> questionGroups = survey.getQuestionGroups();
        for (QuestionGroup questionGroup : questionGroups) {
            List<Question> questions = questionGroup.getQuestions();
            System.out.println(" **** " + questionGroup.getLanguageSettings().getTitle());
            for (Question question : questions) {
                System.out.println(question.getId() + " " + question.getLanguageSettings().getTitle());
            }
        }
    }

}

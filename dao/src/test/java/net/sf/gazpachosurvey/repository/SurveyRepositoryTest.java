package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepository-dataset.xml")
@Transactional
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository repository;

    @Test
    @Rollback(value = false)
    public void saveTest() {
        System.out.println("Inicio");
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

package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepository-dataset.xml")
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository repository;

    @Test
    public void findOne() {
        int surveyId = 3;
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

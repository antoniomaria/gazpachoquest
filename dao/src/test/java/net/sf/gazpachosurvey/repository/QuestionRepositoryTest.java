package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;

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
@DatabaseSetup("QuestionRepository-dataset.xml")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    public void findQuestionsBySurvey() {
        int surveyId = 2;
        // TODO Check that questions are sorted by questionGroupOrder and
        // questionOrder
        List<Question> questions = repository.findQuestionsBySurvey(surveyId);
        assertThat(questions).hasSize(8);

    }

    @Test
    public void findQuestionByQuestionGroup() {
        int questionGroupId = 4;
        // TODO Check order
        List<Question> questions = repository.findQuestionByQuestionGroup(questionGroupId);
        assertThat(questions).hasSize(3);

    }
}

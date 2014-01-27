package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@DatabaseSetup("QuestionRepository-dataset.xml")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    public void findOneByPositionInQuestionGroupTest() {
        int questionGroupId = 4;
        int position = 1;
        Question question = repository.findOneByPositionInQuestionGroup(questionGroupId, position);
        assertThat(question).isEqualTo(Question.with().id(30).build());
    }

    @Test
    public void findPositionInQuestionGroupTest() {
        Integer questionId = 13;
        Integer position = repository.findPositionInQuestionGroup(questionId);
        assertThat(position).isEqualTo(2);
    }

    @Test
    public void findQuestionByQuestionGroup() {
        int questionGroupId = 4;
        List<Question> questions = repository.findByQuestionGroupId(questionGroupId);
        assertThat(questions).containsExactly(Question.with().id(14).build(), Question.with().id(30).build(),
                Question.with().id(13).build());
    }

    @Test
    public void findQuestionsBySurvey() {
        int surveyId = 2;
        List<Question> questions = repository.findByQuestionnairId(surveyId);
        assertThat(questions).containsExactly(Question.with().id(31).build(), Question.with().id(32).build(),
                Question.with().id(36).build(), Question.with().id(14).build(), Question.with().id(30).build(),
                Question.with().id(13).build(), Question.with().id(40).build(), Question.with().id(51).build());

    }

    @Test
    @Transactional
    public void findByExample() {
        int parentId = 44;
        Question parentQuestion = repository.findOne(44);
        Question example = Question.with().parent(Question.with().id(parentId).build()).build();

        List<Question> questions = repository.findByExample(example, new SearchParameters());

        System.out.println("de winner is " + questions);
    }

}

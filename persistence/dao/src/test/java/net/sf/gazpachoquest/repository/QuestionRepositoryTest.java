package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.qbe.support.SearchMode;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionRepository-dataset.xml")
@DatabaseTearDown("QuestionRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    public void findOneByPositionInQuestionGroupTest() {
        int questionGroupId = 9;
        int position = 2;
        Question question = repository.findOneByPositionInQuestionGroup(questionGroupId, position);
        assertThat(question).isEqualTo(Question.with().id(29).build());
    }

    @Test
    public void findPositionInQuestionGroupTest() {
        Integer questionId = 31;
        Integer position = repository.findPositionInQuestionGroup(questionId);
        assertThat(position).isEqualTo(1);
    }

    @Test
    public void findQuestionByQuestionGroup() {
        int questionGroupId = 11;
        List<Question> questions = repository.findByQuestionGroupId(questionGroupId);
        assertThat(questions).containsExactly(Question.with().id(39).build(), Question.with().id(50).build());
    }

    @Test
    public void findQuestionsByQuestionnairDefinitionId() {
        Integer questionnairDefinitionId = 7;
        List<Question> questions = repository.findByQuestionnairId(questionnairDefinitionId);
        assertThat(questions).containsExactly(Question.with().id(12).build(), Question.with().id(13).build(),
                Question.with().id(29).build(), Question.with().id(30).build(), Question.with().id(31).build(),
                Question.with().id(35).build(), Question.with().id(39).build(), Question.with().id(50).build());
    }

    @Test
    public void findByExample() {
        Question example = Question.with().code("Q7.1").build();

        List<Question> questions = repository
                .findByExample(example, new SearchParameters().searchMode(SearchMode.LIKE));
        assertThat(questions).containsExactly(Question.with().id(46).build());
        assertThat(questions.get(0).getParent()).isNotNull();

        questions = repository.findByExample(Question.with().parent(Question.with().id(39).build()).build(),
                new SearchParameters().searchMode(SearchMode.LIKE));

        assertThat(questions).containsExactly(Question.with().id(46).build(), Question.with().id(47).build(),
                Question.with().id(48).build(), Question.with().id(49).build());

    }
}

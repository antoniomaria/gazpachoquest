package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.repository.qbe.SearchMode;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    public void findOneByPositionInQuestionGroupTest() {
        int questionGroupId = 8;
        int position = 1;
        Question question = repository.findOneByPositionInQuestionGroup(questionGroupId, position);
        assertThat(question).isEqualTo(Question.with().id(18).build());
    }

    @Test
    public void findPositionInQuestionGroupTest() {
        Integer questionId = 36;
        Integer position = repository.findPositionInQuestionGroup(questionId);
        assertThat(position).isEqualTo(1);
    }

    @Test
    public void findQuestionByQuestionGroup() {
        int questionGroupId = 10;
        List<Question> questions = repository.findByQuestionGroupId(questionGroupId);
        assertThat(questions).containsExactly(Question.with().id(44).build(), Question.with().id(55).build());
    }

    @Test
    public void findQuestionsByQuestionnairDefinitionId() {
        Integer questionnairDefinitionId = 6;
        List<Question> questions = repository.findByQuestionnairId(questionnairDefinitionId);
        assertThat(questions).containsExactly(Question.with().id(17).build(), Question.with().id(18).build(),
                Question.with().id(34).build(), Question.with().id(35).build(), Question.with().id(36).build(),
                Question.with().id(40).build(), Question.with().id(44).build(), Question.with().id(55).build());
    }

    @Test
    @Transactional
    public void findByExample() {
        Question example = Question.with().code("Q7.1").build();

        List<Question> questions = repository
                .findByExample(example, new SearchParameters().searchMode(SearchMode.LIKE));
        assertThat(questions).containsExactly(Question.with().id(51).build());
        assertThat(questions.get(0).getParent()).isNotNull();

        questions = repository.findByExample(Question.with().parent(Question.with().id(44).build()).build(),
                new SearchParameters().searchMode(SearchMode.LIKE));

        assertThat(questions).containsExactly(Question.with().id(51).build(), Question.with().id(52).build(),
                Question.with().id(53).build(), Question.with().id(54).build());

    }
}

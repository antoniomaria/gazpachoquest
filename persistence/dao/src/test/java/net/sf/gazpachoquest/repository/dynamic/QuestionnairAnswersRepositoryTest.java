package net.sf.gazpachoquest.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairAnswersRepository-dataset.xml")
@DatabaseTearDown("QuestionnairAnswersRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairAnswersRepositoryTest {

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int answersId = 5;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnair_answers_7 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void saveTest() {
        Questionnair questionnair = questionnairRepository.findOne(58);
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();

        QuestionnairAnswers questionnairAnswers = QuestionnairAnswers.with().id(answersId).build();

        questionnairAnswers.setAnswer("q1", "Antonio Maria");
        questionnairAnswers.setAnswer("q2", "O5");
        questionnairAnswers.setAnswer("q3", 33);
        String longAnswer = "I started to work in IECISA, 10 years ago";
        questionnairAnswers.setAnswer("q4", ArrayUtils.toObject(longAnswer.toCharArray()));
        questionnairAnswers.setAnswer("q5", "O2");
        questionnairAnswers.setAnswer("q6", "O1");

        // Radio options
        questionnairAnswers.setAnswer("q7_1", "O1");
        questionnairAnswers.setAnswer("q7_2", "O2");
        questionnairAnswers.setAnswer("q7_3", "O3");
        questionnairAnswers.setAnswer("q7_4", "O1");

        // Checkbox list
        questionnairAnswers.setAnswer("q8_o1", Boolean.TRUE);
        questionnairAnswers.setAnswer("q8_o2", Boolean.TRUE);
        questionnairAnswers.setAnswer("q8_o3", Boolean.TRUE);
        questionnairAnswers.setAnswer("q8_o4", Boolean.FALSE);
        questionnairAnswers = repository.save(questionnairDefinition.getId(), questionnairAnswers);

        Map<String, Object> answers = jdbcTemplate.queryForMap(
                "select q1,q2,q3,q5,q6,q7_1,q8_o1 from questionnair_answers_7 where id = ?", answersId);
        assertThat(answers).isNotEmpty();
        assertThat(answers.get("q1")).isEqualTo("Antonio Maria");
        // Updating
        questionnairAnswers = QuestionnairAnswers.with().id(answersId).build();
        questionnairAnswers.setAnswer("q1", "Antonio Maria Sanchez Berrocal");
        questionnairAnswers = repository.save(questionnairDefinition.getId(), questionnairAnswers);
        assertThat(questionnairAnswers.getAnswer("q1")).isEqualTo("Antonio Maria Sanchez Berrocal");
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnair_answers_7 where id = ?", answersId);
    }
}

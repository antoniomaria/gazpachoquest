package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairAnswersService-dataset.xml")
@DatabaseTearDown("QuestionnairAnswersService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairAnswersServiceTest {

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final int answersId = 5;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnair_answers_7 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void save() {
        Questionnair questionnair = Questionnair.with().id(58).answersId(answersId).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnairAnswersService.save(questionnair, questionCode, answer);

        Map<String, Object> answers = jdbcTemplate.queryForMap(
                "select q1,q2,q3,q5,q6,q7_1,q8_o1 from questionnair_answers_7 where id = ?", answersId);
        assertThat(answers).isNotEmpty();
        assertThat(answers.get("q1")).isEqualTo("Antonio Maria");

    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnair_answers_7 where id = ?", answersId);
    }

}

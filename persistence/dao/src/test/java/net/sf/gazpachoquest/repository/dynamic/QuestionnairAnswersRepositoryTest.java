package net.sf.gazpachoquest.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireAnswers;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.repository.QuestionnaireRepository;
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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnaireAnswersRepository-dataset.xml")
@DatabaseTearDown("QuestionnaireAnswersRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairAnswersRepositoryTest {

    @Autowired
    private QuestionnaireAnswersRepository repository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionnaireDefinitionRepository questionnaireDefinitionRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final int answersId = 5;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnaire_answers_7 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void saveTest() {
        Questionnaire questionnaire = questionnaireRepository.findOne(58);
        QuestionnaireDefinition questionnaireDefinition = questionnaire.getQuestionnairDefinition();

        QuestionnaireAnswers questionnaireAnswers = QuestionnaireAnswers.with().id(answersId).build();

        questionnaireAnswers.setAnswer("q1", "Antonio Maria");
        questionnaireAnswers.setAnswer("q2", "O5");
        questionnaireAnswers.setAnswer("q3", 33);
        String longAnswer = "I started to work in IECISA, 10 years ago";
        questionnaireAnswers.setAnswer("q4", ArrayUtils.toObject(longAnswer.toCharArray()));
        questionnaireAnswers.setAnswer("q5", "O2");
        questionnaireAnswers.setAnswer("q6", "O1");

        // Radio options
        questionnaireAnswers.setAnswer("q7_1", "O1");
        questionnaireAnswers.setAnswer("q7_2", "O2");
        questionnaireAnswers.setAnswer("q7_3", "O3");
        questionnaireAnswers.setAnswer("q7_4", "O1");

        // Checkbox list
        questionnaireAnswers.setAnswer("q8_o1", Boolean.TRUE);
        questionnaireAnswers.setAnswer("q8_o2", Boolean.TRUE);
        questionnaireAnswers.setAnswer("q8_o3", Boolean.TRUE);
        questionnaireAnswers.setAnswer("q8_o4", Boolean.FALSE);
        questionnaireAnswers = repository.save(questionnaireDefinition.getId(), questionnaireAnswers);

        Map<String, Object> answers = jdbcTemplate.queryForMap(
                "select q1,q2,q3,q5,q6,q7_1,q8_o1 from questionnaire_answers_7 where id = ?", answersId);
        assertThat(answers).isNotEmpty();
        assertThat(answers.get("q1")).isEqualTo("Antonio Maria");
        // Updating
        questionnaireAnswers = QuestionnaireAnswers.with().id(answersId).build();
        questionnaireAnswers.setAnswer("q1", "Antonio Maria Sanchez Berrocal");
        questionnaireAnswers = repository.save(questionnaireDefinition.getId(), questionnaireAnswers);
        assertThat(questionnaireAnswers.getAnswer("q1")).isEqualTo("Antonio Maria Sanchez Berrocal");
    }

    @After
    public void tearDown() {
        try {
            jdbcTemplate.update("delete from questionnaire_answers_7 where id = ?", answersId);

        } catch (Exception e) {

        }
    }
}

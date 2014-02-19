package net.sf.gazpachosurvey.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.sql.Types;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairAnswersRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairAnswersRepositoryTest {

    @Autowired
    private DataSource datasource;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(datasource);
        repository.activeAllAnswers();
    }

    public void collectAnswersTest() {
        Integer questionnairIdInteger = 6;
        QuestionnairDefinition questionnair = questionnairDefinitionRepository.findOne(questionnairIdInteger);

        repository.collectAnswers(questionnair);
        assertThat(
                JdbcTestUtils.countRowsInTable(jdbcTemplate,
                        String.format("%s%d", QuestionnairAnswersRepository.ENTITY_NAME_PREFIX, questionnair.getId())))
                .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void saveTest() {
        Questionnair questionnair = questionnairRepository.findOne(58);
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();

        QuestionnairAnswers questionnairAnswers = new QuestionnairAnswers();

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

        Integer id = questionnairAnswers.getId();
        assertThat(id).isNotNull();

        // Updating
        questionnairAnswers = new QuestionnairAnswers();
        questionnairAnswers.setId(id);
        questionnairAnswers.setAnswer("q1", "Antonio Maria Sanchez Berrocal");
        questionnairAnswers = repository.save(questionnairDefinition.getId(), questionnairAnswers);
        assertThat(questionnairAnswers.getAnswer("q1")).isEqualTo("Antonio Maria Sanchez Berrocal");
    }

    @Test
    public void findByOneTest() {
        Integer id = 1;
        String q1 = "Antonio Maria";
        String q2 = "O5";
        Integer q3 = 33;

        // define query arguments
        Object[] params = new Object[] { id, q1, q2, q3 };

        // define SQL types of the arguments
        int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

        String insertSql = "INSERT INTO questionnair_answers_6 (id, q1, q2, q3) values(?,?,?,?)";
        int row = jdbcTemplate.update(insertSql, params, types);
        assertThat(row).isGreaterThan(0);

        Questionnair questionnair = questionnairRepository.findOne(58);
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();

        QuestionnairAnswers fetched = repository.findByOne(questionnairDefinition.getId(), id);
        assertThat(fetched.getAnswer("q1")).isEqualTo("Antonio Maria");
    }
}

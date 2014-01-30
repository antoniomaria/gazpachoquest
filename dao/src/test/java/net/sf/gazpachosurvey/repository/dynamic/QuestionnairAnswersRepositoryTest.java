package net.sf.gazpachosurvey.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.ArrayUtils;
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

    @Test
    public void collectAnswersTest() {
        Integer questionnairIdInteger = 6;
        QuestionnairDefinition questionnair = questionnairDefinitionRepository.findOne(questionnairIdInteger);

        repository.collectAnswers(questionnair);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        assertThat(
                JdbcTestUtils.countRowsInTable(jdbcTemplate,
                        String.format("%s%d", QuestionnairAnswersRepository.TABLE_NAME_PREFIX, questionnair.getId())))
                .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void saveTest() {
        Questionnair questionnair = questionnairRepository.findOne(63);

        repository.activeAllAnswers();
        QuestionnairAnswers respondentAnswers = new QuestionnairAnswers();
        respondentAnswers.getAnswers().put("q1", "Antonio Maria");
        respondentAnswers.getAnswers().put("q2", "O5");
        respondentAnswers.getAnswers().put("q3", 33);
        String longAnswer = "I started to work in IECISA, 10 years ago";
        respondentAnswers.getAnswers().put("q4", ArrayUtils.toObject(longAnswer.toCharArray()));
        respondentAnswers.getAnswers().put("q5", "O2");
        respondentAnswers.getAnswers().put("q6", "O1");

        // Radio options
        respondentAnswers.getAnswers().put("q7_1", "O1");
        respondentAnswers.getAnswers().put("q7_2", "O2");
        respondentAnswers.getAnswers().put("q7_3", "O3");
        respondentAnswers.getAnswers().put("q7_4", "O1");

        // Checkbox list
        respondentAnswers.getAnswers().put("q8_o1", Boolean.TRUE);
        respondentAnswers.getAnswers().put("q8_o2", Boolean.TRUE);
        respondentAnswers.getAnswers().put("q8_o3", Boolean.TRUE);
        respondentAnswers.getAnswers().put("q8_o4", Boolean.FALSE);

        respondentAnswers.setQuestionnair(questionnair);
        respondentAnswers = repository.save(respondentAnswers);
        assertThat(respondentAnswers.getId()).isGreaterThanOrEqualTo(1);

        repository.findByOne(questionnair.getQuestionnairDefinition(), respondentAnswers.getId());
    }

    @Test
    public void findByQuestionnairIdTest() {
        repository.activeAllAnswers();
        Integer questionnairId = 63;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);

        // repository.findByQuestionnairId(questionnairId);
    }
}

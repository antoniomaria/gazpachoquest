package net.sf.gazpachosurvey.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.repository.StudyRepository;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairAnswersRepository-dataset.xml")
public class QuestionnairAnswersRepositoryTest {

    @Autowired
    private DataSource datasource;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private StudyRepository studyRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Test
    public void collectAnswersTest() {
        QuestionnairDefinition selectedSurvey = questionnairDefinitionRepository.findOne(58);

        repository.collectAnswers(selectedSurvey);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        assertThat(
                JdbcTestUtils.countRowsInTable(jdbcTemplate,
                        String.format("%s%d", QuestionnairAnswersRepository.TABLE_NAME_PREFIX, selectedSurvey.getId())))
                .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void saveRespondentTest() {
        Study study = studyRepository.findOne(131);

        Questionnair questionnair = new Questionnair();
        questionnair.setId(1);
        questionnair.setStudy(study);

        repository.activeAllAnswers();
        QuestionnairAnswers respondentAnswers = new QuestionnairAnswers();

        respondentAnswers.setQuestionnair(questionnair);

        respondentAnswers = repository.save(respondentAnswers);
        assertThat(questionnair.getId()).isGreaterThanOrEqualTo(1);
    }
}

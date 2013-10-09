package net.sf.gazpachosurvey.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Date;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.SurveyRepository;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentRepository.xml")
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private DataSource datasource;

    @Test
    public void collectAnswersTest() {
        Survey selectedSurvey = surveyRepository.findOne(3);

        repository.collectAnswers(selectedSurvey);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        assertThat(
                JdbcTestUtils.countRowsInTable(jdbcTemplate, "respondents_3"))
                .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void saveRespondentTest() {
        Survey selectedSurvey = surveyRepository.findOne(3);

        repository.enableAllAnswers();
        Respondent respondent = new Respondent();
        respondent.setSurveyId(selectedSurvey.getId());
        respondent.setSurveyRunningId(100);
        respondent.setStartDate(new Date());
        respondent.setIpAddress("127.0.0.2");
        respondent = repository.save(respondent);
        assertThat(respondent.getId()).isGreaterThanOrEqualTo(1);
    }
}

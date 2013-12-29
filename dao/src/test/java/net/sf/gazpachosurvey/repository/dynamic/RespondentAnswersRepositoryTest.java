package net.sf.gazpachosurvey.repository.dynamic;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.RespondentAnswers;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyInstance;
import net.sf.gazpachosurvey.repository.SurveyInstanceRepository;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentAnswersRepository-dataset.xml")
public class RespondentAnswersRepositoryTest {

    @Autowired
    private DataSource datasource;

    @Autowired
    private RespondentAnswersRepository repository;

    @Autowired
    private SurveyInstanceRepository surveyInstanceRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    public void collectAnswersTest() {
        Survey selectedSurvey = surveyRepository.findOne(58);

        repository.collectAnswers(selectedSurvey);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        assertThat(
                JdbcTestUtils.countRowsInTable(jdbcTemplate,
                        String.format("%s%d", RespondentAnswersRepository.TABLE_NAME_PREFIX, selectedSurvey.getId())))
                .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void saveRespondentTest() {
        SurveyInstance surveyInstance = surveyInstanceRepository.findOne(131);

        Respondent respondent = new Respondent();
        respondent.setId(1);
        respondent.setSurveyInstance(surveyInstance);

        repository.activeAllAnswers();
        RespondentAnswers respondentAnswers = new RespondentAnswers();

        respondentAnswers.setRespondent(respondent);

        respondentAnswers = repository.save(respondentAnswers);
        assertThat(respondent.getId()).isGreaterThanOrEqualTo(1);
    }
}

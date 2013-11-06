package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentRepository-dataset.xml")
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyRunningRepository surveyRunningRespository;

    @Test
    public void saveTest() {
        SurveyRunning running = surveyRunningRespository.findOne(93);

        Respondent respondent = new Respondent();
        respondent.setIpAddress("127.0.0.1");
        respondent.setStartDate(new DateTime());
        respondent.setSurvey(running.getSurvey());
        respondent.setSurveyRunning(running);
        Respondent created = repository.save(respondent);

        assertThat(created.getId()).isGreaterThan(0);
    }

}

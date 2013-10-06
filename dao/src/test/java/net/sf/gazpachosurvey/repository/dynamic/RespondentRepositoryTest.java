package net.sf.gazpachosurvey.repository.dynamic;

import java.util.Date;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.types.EntityStatus;

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
@DatabaseSetup("RespondentRepository.xml")
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    public void collectAnswersTest() {
        System.out.println("inicio!");
        Survey selectedSurvey = surveyRepository.findOne(3);
        System.out.println("fin!");
        repository.collectAnswers(selectedSurvey);
        selectedSurvey.setStatus(EntityStatus.CONFIRMED);

    }

    @Test
    public void saveRespondentTest() {
        Survey selectedSurvey = surveyRepository.findOne(3);

        repository.enableAllAnswers();
        Respondent respondent = new Respondent();
        // respondent.setId(151);
        respondent.setSurveyId(selectedSurvey.getId());
        respondent.setSurveyRunningId(100);
        respondent.setStartDate(new Date());
        respondent.setIpAddress("127.0.0.2");
        repository.save(respondent);
    }
}

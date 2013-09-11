package net.sf.gazpachosurvey.repository.dynamic;

import java.util.Date;

import net.sf.gazpachosurvey.domain.core.Respondent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/jpa-context.xml" })
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;

    @Test
    public void saveRespondentTest() {
        repository.enableAllAnswers();
        Respondent respondent = new Respondent();
        respondent.setId(151);
        respondent.setSurveyId(1);
        respondent.setSurveyRunningId(100);
        respondent.setStartDate(new Date());
        respondent.setIpAddress("127.0.0.2");
        repository.save(respondent);
    }
}

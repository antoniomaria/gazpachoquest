package net.sf.opensurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsqldb")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepositoryTest-dataset.xml")
@Transactional
public class SurveyRunningRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(SurveyRunningRepositoryTest.class);

    @Autowired
    public SurveyRunningRepository surveyRunningRepository;

    @Test
    public void findByExampleTest() {
        Survey survey = new Survey();
        // survey.setId(1);
        survey.setDescription("Customer satisfaction surveys");

        SurveyRunning example = new SurveyRunning();
        example.setSurvey(survey);

        List<SurveyRunning> surveysRunning = surveyRunningRepository.findByExample(example, new SearchParameters());
        for (SurveyRunning surveyRunning : surveysRunning) {
            logger.debug(surveyRunning.toString());
        }
    }
}

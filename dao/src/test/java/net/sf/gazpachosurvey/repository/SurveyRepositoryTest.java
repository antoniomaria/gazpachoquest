package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@DatabaseSetup("SurveyRepositoryTest-dataset.xml")
public class SurveyRepositoryTest {

    private static final Logger logger = LoggerFactory
            .getLogger(SurveyRepositoryTest.class);

    @Autowired
    public SurveyRepository repository;

    @Test
    public void findByExampleTest() {
        Survey survey = repository.findOne(4);

        assertThat(survey.getLanguage()).isEqualTo(Language.EN);
    }

    // @Test
    // public void findByExampleTest() {
    // Survey example = new Survey();
    // example.setDescription("Customer satisfaction surveys");
    // List<Survey> results = repository.findByExample(example,
    // new SearchParameters());
    // for (Survey survey : results) {
    // logger.debug(survey.toString());
    // }
    //
    // example = new Survey();
    //
    // SurveyRunning running = surveyRunningRepository.findOne(1);
    // example.addSurveyRunning(running);
    // logger.info("Find by many-to-many");
    // results = repository.findByExample(example, new SearchParameters());
    // for (Survey survey : results) {
    // logger.debug(survey.toString());
    // }
    //
    // }
}

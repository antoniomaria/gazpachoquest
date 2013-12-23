package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.SurveyInstance;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentRepository-dataset.xml")
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyInstanceRepository surveyInstanceRepository;

    @Test
    public void saveTest() {
        SurveyInstance running = surveyInstanceRepository.findOne(96);

        Respondent respondent = new Respondent();
        respondent.setSurveyInstance(running);
        Respondent created = repository.save(respondent);

        assertThat(created.getId()).isGreaterThan(0);
    }

    @Test
    public void findOneTest() {
        Respondent respondent = repository.findOne(127);
        
        Set<BrowsedElement> browsedElements = respondent.getBrowsedElements();
        assertThat(browsedElements).isNotEmpty();
    }

}

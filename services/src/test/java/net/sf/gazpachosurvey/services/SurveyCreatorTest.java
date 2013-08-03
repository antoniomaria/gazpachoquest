package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/services-context.xml" })
/*
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepositoryTest-dataset.xml")
*/public class SurveyCreatorTest {

    @Autowired
    SurveyCreatorService surveyCreatorService;
    
    @Test
    public void f(){
       SurveyDTO survey = new SurveyDTO();
       survey.setName("mi encuesta" );
       surveyCreatorService.save(survey);
       
    }
}

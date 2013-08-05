package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.SurveyDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/services-context.xml" })
/*
 * @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
 * DirtiesContextTestExecutionListener.class,
 * TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class
 * })
 * 
 * @DatabaseSetup("SurveyRepositoryTest-dataset.xml")
 */public class SurveyCreatorTest {

    @Autowired
    SurveyCreatorService surveyCreatorService;

    @Test
    public void f() {

        SurveyDTO survey = SurveyDTO.with().surveyLanguageSettingsStart().description("description").title("title")
                .surveyLanguageSettingsEnd().build();

        // surveyCreatorService.save(survey);

        System.out.println("fin");

    }
}

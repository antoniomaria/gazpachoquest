package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.types.Language;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyService-dataset.xml")
public class SurveyServiceTest {

    @Autowired
    private SurveyService surveyService;

    @Test
    public void findAllTest() {
        assertThat(surveyService.findAll()).hasSize(2);
    }

    @Test
    public void confirmTest() {
        SurveyDTO survey = SurveyDTO.with().id(2).build();
        surveyService.confirm(survey);
    }

    @Test
    public void findOneTest() {
        int surveyId = 2;
        SurveyDTO survey = surveyService.findOne(surveyId);

        SurveyDTO surveyWithQuestions = surveyService.findOne(surveyId, "SurveyWithQuestions");
        assertThat(survey).isNotNull();
    }

    @Test
    public void saveTranslationTest() {
        SurveyLanguageSettingsDTO languageSettings = new SurveyLanguageSettingsDTO();
        languageSettings.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        languageSettings.setDescription("Donec pellentesque consequat orci.");
        int surveyId = 2;
        surveyService.saveTranslation(surveyId, Language.FR, languageSettings);

        Set<Language> translations = surveyService.translationsSupported(surveyId);

        assertThat(translations).contains(Language.FR);
    }

}

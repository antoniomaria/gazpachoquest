package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.types.Language;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyService-dataset.xml")
public class SurveyServiceTest {

    @Autowired
    private SurveyService surveyService;

    @Test
    public void saveTest() {
        SurveyLanguageSettings languageSettings = SurveyLanguageSettings.with().title("My Survey").build();
        Survey survey = Survey.with().language(Language.EN).languageSettings(languageSettings).build();
        survey = surveyService.save(survey);
        DateTime lastModifiedDate = survey.getLastModifiedDate();

        Survey created = surveyService.findOne(survey.getId());
        SurveyLanguageSettings newLanguageSettings = SurveyLanguageSettings.with().title("My Survey. Ver 1").build();
        created.setLanguageSettings(newLanguageSettings);

        Survey updated = surveyService.save(created);
        assertThat(lastModifiedDate).isNotEqualTo(updated.getLastModifiedDate());
    }

    @Test
    public void findAllTest() {
        assertThat(surveyService.findAll()).hasSize(2);
    }

    @Test
    public void confirmTest() {
        Survey survey = Survey.with().id(2).build();
        surveyService.confirm(survey);
    }

    @Test
    public void findOneTest() {
        int surveyId = 2;
        Survey survey = surveyService.findOne(surveyId);
        assertThat(survey).isNotNull();
    }

    @Test
    public void saveTranslationTest() {
        SurveyLanguageSettings languageSettings = new SurveyLanguageSettings();
        languageSettings.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        languageSettings.setDescription("Donec pellentesque consequat orci.");
        int surveyId = 2;
        SurveyTranslation translation = SurveyTranslation.with().translatedEntityId(surveyId).language(Language.FR)
                .languageSettings(languageSettings).build();
        surveyService.saveTranslation(translation);
        Set<Language> translations = surveyService.translationsSupported(surveyId);

        assertThat(translations).contains(Language.FR);
    }

    @Test
    public void questionGroupsCountTest() {
        int surveyId = 2;
        long count = surveyService.questionGroupsCount(surveyId);
        assertThat(count).isEqualTo(3);
    }
}

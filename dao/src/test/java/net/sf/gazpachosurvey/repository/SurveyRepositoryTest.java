package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.types.Language;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.core.Assert.*;
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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
       // TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyRepositoryTest-dataset.xml")
public class SurveyRepositoryTest {

    private static final Logger logger = LoggerFactory
            .getLogger(SurveyRepositoryTest.class);

    @Autowired
    public SurveyRepository repository;

    @Test
    public void findByExampleTest() {
        int surveyId = 4;

        Survey survey = repository.findOne(4);

        SurveyLanguageSettings languageSettings = SurveyLanguageSettings.with()
                .title("Encuesta de comida rapida")
                .description("Queremos valorar la calidad en este restaurante")
                .welcomeText("Gracias por responder a estas preguntas").build();
        survey.saveTranslation(Language.ES, languageSettings);
        repository.save(survey);

        Survey surveyInSpanish = repository.findOne(surveyId, Language.ES);
        assertThat(surveyInSpanish.getLanguage()).isEqualTo(Language.ES);

        SurveyLanguageSettings languageSettingsNew = SurveyLanguageSettings.with()
                .title("Cuestionario sobre la calidad el servicio")
                .description("Queremos valorar la calidad en este restaurante")
                .welcomeText("Gracias por responder a estas preguntas").build();
        survey.saveTranslation(Language.ES, languageSettingsNew);
        
        surveyInSpanish.getTranslations().get(Language.ES).getLanguageSettings().setTitle("Cuestionario sobre la calidad el servicio");
        repository.save(surveyInSpanish);
        surveyInSpanish = repository.findOne(surveyId, Language.ES);
        assertThat(surveyInSpanish.getLanguageSettings().getTitle()).isEqualTo(
                "Cuestionario sobre la calidad el servicio");
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

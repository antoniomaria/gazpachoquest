package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-context.xml" })
@ActiveProfiles("postgres")
public class DataBasePopulator {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public SurveyRepository surveyRepository;

    @Autowired
    public SurveyRunningRepository surveyRunningRepository;

    @Autowired
    public PageRepository pageRepository;

    @Test
    public void populate() {
        User support = new User();
        support.setEmail("admin" + System.currentTimeMillis()
                + "@gazpachosurvey.net");
        support.setFirstName("adminx");
        support.setLastName("adminx");
        User auditor = new User();
        auditor.setId(1);
        // support.setCreatedBy(auditor);
        userRepository.save(support);

        Survey survey = new Survey();
        SurveyLanguageSettings languageSettings = new SurveyLanguageSettings();
        languageSettings.setTitle("Asiakastyytyväisyyskyselyt");
        languageSettings.setDescription("Customer satisfaction surveys");

        survey.setLanguageSettings(languageSettings);
        survey.setLanguage(Language.FI);

        languageSettings = new SurveyLanguageSettings();
        languageSettings.setTitle("Encuesta satisfacion");
        languageSettings.setDescription("Que piensan los clientes de ti");

        survey.setTranslation(Language.ES, languageSettings);
        surveyRepository.save(survey);

        //
        // Survey survey = new Survey("Asiakastyytyväisyyskyselyt");
        // survey.setDescription("Customer satisfaction surveys");
        // SurveyLanguageSettings languageSettings = new
        // SurveyLanguageSettings();
        //
        // Page page = new Page();
        // page.setTitle("Pagina 1");
        // page.setLanguage(Language.ES);
        // survey.addPage(page);
        //
        // page = new Page();
        // page.setTitle("Pagina 2");
        // page.setLanguage(Language.ES);
        // survey.addPage(page);
        // surveyRepository.save(survey);
        //
        // survey = new Survey("Markkinatutkimus");
        // survey.setTitle("Market research surveys");
        // survey.setTranslation(Language.ES, "Investigación de mercado");
        // survey.setTranslation(Language.FI, "Markkinatutkimus");
        // surveyRepository.save(survey);
        // survey = new
        // Survey("Kokous- ja tapahtumasuunnittelukyselylomakkeet");
        // survey.setDescription("Event planning surveys");
        // survey.setTranslation(Language.ES, "Planificación de eventos");
        // survey.setTranslation(Language.FI,
        // "Kokous- ja tapahtumasuunnittelukyselylomakkeet");
        // surveyRepository.save(survey);
        // survey = new Survey("Työtyytyväisyyskysely");
        // survey.setTranslation(Language.ES,
        // "Encuesta de satisfación de cliente");
        // survey.setDescription("Job satisfaction survey");
        // surveyRepository.save(survey);
        //
        // SurveyRunning running = new SurveyRunning();
        // running.setSurvey(survey);
        // running.setName("My first survey");
        // surveyRunningRepository.save(running);
        //
        // Survey mysurvey = surveyRepository.findAll().get(0);
        // List<Page> pages = mysurvey.getPages();
        // page = pages.remove(1);
        // pages.add(0, page);
        // surveyRepository.save(mysurvey);
    }
}

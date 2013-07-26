package net.sf.opensurvey.repository;

import java.util.Date;
import java.util.List;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-context.xml" })
@ActiveProfiles("mysql")
public class DataBasePopulator {

    @Autowired
    public SurveyRepository surveyRepository;

    @Autowired
    public SurveyRunningRepository surveyRunningRepository;

    @Test
    public void populate() {
        Survey survey = new Survey("Asiakastyytyväisyyskyselyt");
        survey.setDescription("Customer satisfaction surveys");

        Page page = new Page();
        page.setTitle("Pagina 1");
        page.setLanguage(Language.ES);
        survey.addPage(page);

        page = new Page();
        page.setTitle("Pagina 2");
        page.setLanguage(Language.ES);
        survey.addPage(page);

        surveyRepository.save(survey);

        survey = new Survey("Markkinatutkimus");
        survey.setName("Market research surveys");
        survey.setTranslation(Language.ES, "Investigación de mercado");
        survey.setTranslation(Language.FI, "Markkinatutkimus");
        surveyRepository.save(survey);
        survey = new Survey("Kokous- ja tapahtumasuunnittelukyselylomakkeet");
        survey.setDescription("Event planning surveys");
        survey.setTranslation(Language.ES, "Planificación de eventos");
        survey.setTranslation(Language.FI,
                "Kokous- ja tapahtumasuunnittelukyselylomakkeet");
        surveyRepository.save(survey);
        survey = new Survey("Työtyytyväisyyskysely");
        survey.setTranslation(Language.ES, "Encuesta de satisfación de cliente");
        survey.setDescription("Job satisfaction survey");
        surveyRepository.save(survey);

        SurveyRunning running = new SurveyRunning();
        running.setSurvey(survey);
        running.setName("My first survey");
        running.setCreatedBy("admin");
        running.setCreationDate(new Date());
        surveyRunningRepository.save(running);

        Survey mysurvey = surveyRepository.findAll().get(0);

        List<Page> pages = mysurvey.getPages();

        page = pages.remove(1);
        pages.add(0, page);
        surveyRepository.save(mysurvey);
    }
}

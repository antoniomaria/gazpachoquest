package net.sf.opensurvey.repository;

import java.util.Date;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
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
@ActiveProfiles("postgres")
public class DataBasePopulator {

    @Autowired
    public SurveyRepository surveyRepository;

    @Autowired
    public SurveyRunningRepository surveyRunningRepository;

    @Test
    public void populate() {
        Survey survey = new Survey("Asiakastyytyväisyyskyselyt");
        survey.setDescription("Customer satisfaction surveys");
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

        Survey mysurvey = surveyRepository.findAll().get(1);
        System.out.println(mysurvey.getTranslations());
        SurveyTranslation trans = mysurvey.getTranslations().get(
                Language.ES);
        
        System.out.println(trans.getLanguage());
        
        
    }
}

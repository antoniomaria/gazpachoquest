package net.sf.opensurvey.repository;

import java.util.Date;

import net.sf.gazpachosurvey.domain.Survey;
import net.sf.gazpachosurvey.domain.SurveyRunning;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;

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
    public SurveyRepository repository;

    @Autowired
    public SurveyRunningRepository surveyRunningRepository;

    @Test
    public void populate() {
        Survey survey = new Survey("Asiakastyytyväisyyskyselyt");
        survey.setDescription("Customer satisfaction surveys");
        repository.save(survey);
        survey = new Survey("Markkinatutkimus");
        survey.setName("Market research surveys");
        repository.save(survey);
        survey = new Survey("Kokous- ja tapahtumasuunnittelukyselylomakkeet");
        survey.setDescription("Event planning surveys");
        repository.save(survey);
        survey = new Survey("Työtyytyväisyyskysely");
        survey.setDescription("Job satisfaction survey");
        repository.save(survey);

        SurveyRunning running = new SurveyRunning();
        running.setSurvey(survey);
        running.setName("My first survey");
        running.setCreatedBy("admin");
        running.setCreationDate(new Date());
        surveyRunningRepository.save(running);
    }
}

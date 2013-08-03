package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.repository.i18.SurveyTranslationRepository;
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
public class SurveyTranslationRepositoryTest {

    @Autowired
    private SurveyTranslationRepository repository;

    @Test
    public void findByLanguageTest() {
        List<SurveyTranslation> translations = repository.findByLanguage(Language.ES);

        for (SurveyTranslation surveyTranslation : translations) {
            System.out.println(surveyTranslation);

        }
    }
}

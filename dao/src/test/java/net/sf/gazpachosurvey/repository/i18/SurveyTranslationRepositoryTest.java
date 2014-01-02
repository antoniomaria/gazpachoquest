package net.sf.gazpachosurvey.repository.i18;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SurveyTranslationRepository-dataset.xml")
public class SurveyTranslationRepositoryTest {

    @Autowired
    private SurveyTranslationRepository surveyTranslationRepository;

    @Test
    public void findByExample() {
        QuestionnairDefinitionTranslation entity = QuestionnairDefinitionTranslation.with().translatedEntityId(2).build();

        List<QuestionnairDefinitionTranslation> translations = surveyTranslationRepository
                .findByExample(entity, new SearchParameters());

        assertThat(translations).contains(QuestionnairDefinitionTranslation.with().id(3).build());
    }

}

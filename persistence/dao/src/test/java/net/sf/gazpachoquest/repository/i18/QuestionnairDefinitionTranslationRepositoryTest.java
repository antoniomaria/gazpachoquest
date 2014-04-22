package net.sf.gazpachoquest.repository.i18;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
         DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionTranslationRepository-dataset.xml")
@DatabaseTearDown("QuestionnairDefinitionTranslationRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionTranslationRepositoryTest {

    @Autowired
    private QuestionnairDefinitionTranslationRepository questionnairDefinitionTranslationRepository;

    @Test
    public void findByExampleTest() {
        QuestionnairDefinitionTranslation example = QuestionnairDefinitionTranslation.with().language(Language.ES)
                .build();

        List<QuestionnairDefinitionTranslation> translations = questionnairDefinitionTranslationRepository
                .findByExample(example, new SearchParameters());

        assertThat(translations).contains(QuestionnairDefinitionTranslation.with().id(8).build());
    }

}

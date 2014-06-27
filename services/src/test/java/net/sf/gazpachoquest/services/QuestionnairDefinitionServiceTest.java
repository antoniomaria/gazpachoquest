package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;

import org.joda.time.DateTime;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionService-dataset.xml")
@DatabaseTearDown("QuestionnairDefinitionService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionServiceTest {

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Test
    public void confirmTest() {
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().id(7).build();
        questionnairDefinitionService.confirm(questionnairDefinition);
    }

    @Test
    public void findAllTest() {
        assertThat(questionnairDefinitionService.findAll()).hasSize(1);
    }

    @Test
    public void findOneTest() {
        int questionnairDefinitionId = 7;
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionService.findOne(questionnairDefinitionId);
        assertThat(questionnairDefinition).isNotNull();
    }

    @Test
    public void questionGroupsCountTest() {
        int questionnairDefinitionId = 7;
        long count = questionnairDefinitionService.questionGroupsCount(questionnairDefinitionId);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void saveTest() {
        QuestionnairDefinitionLanguageSettings languageSettings = QuestionnairDefinitionLanguageSettings.with()
                .title("My QuestionnairDefinition").description("My description").build();
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().language(Language.EN)
                .languageSettings(languageSettings).build();
        questionnairDefinition = questionnairDefinitionService.save(questionnairDefinition);
        DateTime lastModifiedDate = questionnairDefinition.getLastModifiedDate();

        QuestionnairDefinition created = questionnairDefinitionService.findOne(questionnairDefinition.getId());
        QuestionnairDefinitionLanguageSettings newLanguageSettings = QuestionnairDefinitionLanguageSettings.with()
                .title("My QuestionnairDefinition. Ver 1").description("My description").build();
        created.setLanguageSettings(newLanguageSettings);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        QuestionnairDefinition updated = questionnairDefinitionService.save(created);
        assertThat(lastModifiedDate).isNotEqualTo(updated.getLastModifiedDate());
    }

    @Test
    public void saveTranslationTest() {
        QuestionnairDefinitionLanguageSettings languageSettings = new QuestionnairDefinitionLanguageSettings();
        languageSettings.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        languageSettings.setDescription("Donec pellentesque consequat orci.");
        int questionnairDefinitionId = 7;
        QuestionnairDefinitionTranslation translation = QuestionnairDefinitionTranslation.with()
                .translatedEntityId(questionnairDefinitionId).language(Language.FR).languageSettings(languageSettings)
                .build();
        questionnairDefinitionService.saveTranslation(translation);
        Set<Language> translations = questionnairDefinitionService.translationsSupported(questionnairDefinitionId);

        assertThat(translations).contains(Language.FR);
    }
}

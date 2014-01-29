package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachosurvey.types.Language;

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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionEditorFacadeTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionEditorFacadeTest {

    @Autowired
    private QuestionnairDefinitionEditorFacade questionnairDefinitionEditorFacade;

    @Test
    public void confirmTest() {
        QuestionnairDefinitionDTO questionairDefinition = QuestionnairDefinitionDTO.with().id(6).build();
        questionnairDefinitionEditorFacade.confirm(questionairDefinition);
    }

    @Test
    public void saveQuestionTranslation() {
        QuestionDTO question = new QuestionDTO();
        question.setId(17);

        QuestionLanguageSettingsDTO languageSettings = new QuestionLanguageSettingsDTO();
        languageSettings.setTitle("¿Cual es tu nombre?");

        TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation = new TranslationDTO<>();
        translation.setTranslatedEntity(question);
        translation.setLanguageSettings(languageSettings);
        translation.setLanguage(Language.ES);

        translation = questionnairDefinitionEditorFacade.saveQuestionTranslation(translation);
        assertThat(translation.getId()).isNotNull();
    }
}

package net.sf.gazpachoquest.facades;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.Language;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnaireDefinitionEditorFacadeTest-dataset.xml")
@DatabaseTearDown("QuestionnaireDefinitionEditorFacadeTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireDefinitionEditorFacadeTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireDefinitionEditorFacade questionnaireDefinitionEditorFacade;

    @Test
    public void confirmTest() {
        QuestionnaireDefinitionDTO questionairDefinition = QuestionnaireDefinitionDTO.with().id(7).build();
        questionnaireDefinitionEditorFacade.confirm(questionairDefinition);
    }

    @Test
    public void saveQuestionTranslation() {
        QuestionDTO question = QuestionDTO.with().id(12).build();

        QuestionLanguageSettingsDTO languageSettings = new QuestionLanguageSettingsDTO();
        languageSettings.setTitle("¿Cual es tu nombre?");
        languageSettings.setExplanation("");

        TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation = new TranslationDTO<>();
        translation.setTranslatedEntity(question);
        translation.setLanguageSettings(languageSettings);
        translation.setLanguage(Language.ES);

        translation = questionnaireDefinitionEditorFacade.saveQuestionTranslation(translation);
        assertThat(translation.getId()).isNotNull();
    }

    @Before
    public void setUpSubject() {
        Subject subjectUnderTest = createNiceMock(Subject.class);
        User support = User.with().id(1).build();
        expect(subjectUnderTest.getPrincipal()).andReturn(support).anyTimes();
        replay(subjectUnderTest);
        // 2. Bind the subject to the current thread:
        setSubject(subjectUnderTest);
    }

    @After
    public void tearDownSubject() {
        // 3. Unbind the subject from the current thread:
        clearSubject();
    }
}

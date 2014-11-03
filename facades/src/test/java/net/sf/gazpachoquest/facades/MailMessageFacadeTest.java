package net.sf.gazpachoquest.facades;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.embeddables.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

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
@DatabaseSetup("MailMessageFacadeTest-dataset.xml")
@DatabaseTearDown("MailMessageFacadeTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class MailMessageFacadeTest extends AbstractShiroTest {

    @Autowired
    private MailMessageFacade mailMessageFacade;

    @Test
    public void saveMailMessageTemplateTest() {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO.with()
                .type(MailMessageTemplateType.INVITATION).language(Language.EN).fromAddress("support@gazpacho.net")
                .replyTo("nonreply@gazpacho.net").build();

        MailMessageTemplateLanguageSettingsDTO languageSettings = new MailMessageTemplateLanguageSettingsDTO();
        languageSettings.setSubject("Your questionnaireDefinition");
        languageSettings
                .setBody("Dear Mr. $lastname, <br> You have been invited to take this questionnaireDefinition. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"\">Click here</a> to take the questionnaireDefinition");
        mailMessageTemplate.setLanguageSettings(languageSettings);

        mailMessageTemplate = mailMessageFacade.save(mailMessageTemplate);
        assertThat(mailMessageTemplate.getId()).isNotNull();
    }

    @Test
    public void saveMailMessageTemplateTranslationTest() {
        MailMessageTemplateLanguageSettingsDTO languageSettingsInSpanish = MailMessageTemplateLanguageSettingsDTO
                .with()
                .subject("Tu encuesta")
                .body("Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>"
                        + "Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario"
                        + "<a href=\"\">Click aqui</a> para empezar").build();

        TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation = new TranslationDTO<>();
        translation.setLanguageSettings(languageSettingsInSpanish);
        translation.setLanguage(Language.ES);
        translation.setTranslatedEntity(MailMessageTemplateDTO.with().id(55).build());

        translation = mailMessageFacade.saveTranslation(translation);
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

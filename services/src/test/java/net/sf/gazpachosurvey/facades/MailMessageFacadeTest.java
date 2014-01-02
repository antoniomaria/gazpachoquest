package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("MailMessageFacadeTest-dataset.xml")
public class MailMessageFacadeTest {

    @Autowired
    MailMessageFacade mailMessageFacade;

    @Test
    public void saveMailMessageTemplateTest() {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO.with()
                .type(MailMessageTemplateType.INVITATION).language(Language.EN).fromAddress("support@gazpacho.net")
                .replyTo("nonreply@gazpacho.net").build();

        MailMessageTemplateLanguageSettingsDTO languageSettings = new MailMessageTemplateLanguageSettingsDTO();
        languageSettings.setSubject("Your questionnairDefinition");
        languageSettings
                .setBody("Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"\">Click here</a> to take the questionnairDefinition");
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
        translation.setTranslatedEntity(MailMessageTemplateDTO.with().id(56).build());

        translation = mailMessageFacade.saveTranslation(translation);
        assertThat(translation.getId()).isNotNull();
    }
}

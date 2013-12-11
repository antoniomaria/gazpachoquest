package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
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
@DatabaseSetup("MailMessageTemplateService-dataset.xml")
public class MailMessageTemplateServiceTest {

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        MailMessageTemplate mailMessageTemplate = MailMessageTemplate.with().type(MailMessageTemplateType.INVITATION)
                .language(Language.EN).fromAddress("support@gazpacho.net").replyTo("nonreply@gazpacho.net").build();

        MailMessageTemplateLanguageSettings languageSettings = new MailMessageTemplateLanguageSettings();
        languageSettings.setSubject("Your survey");
        languageSettings
                .setBody("Dear Mr. $lastname, <br> You have been invited to take this survey. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"\">Click here</a> to take the survey");
        mailMessageTemplate.setLanguageSettings(languageSettings);

        mailMessageTemplate = mailMessageTemplateService.save(mailMessageTemplate);

        MailMessageTemplateLanguageSettings languageSettingsInSpanish = new MailMessageTemplateLanguageSettings();
        languageSettingsInSpanish.setSubject("Tu encuesta");
        languageSettingsInSpanish
                .setBody("Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>"
                        + "Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario"
                        + "<a href=\"\">Click aqui</a> para empezar");
        MailMessageTemplateTranslation translation = new MailMessageTemplateTranslation();
        translation.setLanguageSettings(languageSettingsInSpanish);
        mailMessageTemplate.addTranslation(Language.ES, translation);
        //mailMessageTemplateService.saveTranslation(mailMessageTemplate.getId(), Language.ES, languageSettings);
         mailMessageTemplateService.save(mailMessageTemplate);

        
        MailMessageTemplate localizedMailMessageTemplate = mailMessageTemplateService.findOne(
                mailMessageTemplate.getId(), Language.ES);
        assertThat(localizedMailMessageTemplate.getLanguageSettings().getSubject()).isEqualTo(
                languageSettings.getSubject());
    }

    @Test
    public void languagesTest() {
        Set<Language> translations = mailMessageTemplateService.translationsSupported(55);
        assertThat(translations).contains(Language.ES);
    }
}

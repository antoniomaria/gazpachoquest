package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

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
@DatabaseSetup("MailMessageTemplateService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class MailMessageTemplateServiceTest {

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    @Autowired
    private UserService userService;

    @Test
    public void findByExampleTest() {
        MailMessageTemplate example = new MailMessageTemplate();
        example.setQuestionnairDefinition(QuestionnairDefinition.with().id(6).build());
        List<MailMessageTemplate> results = mailMessageTemplateService.findByExample(example, new SearchParameters());
        assertThat(results).contains(MailMessageTemplate.with().id(55).build());
    }

    @Test
    public void languagesTest() {
        Set<Language> translations = mailMessageTemplateService.translationsSupported(55);
        assertThat(translations).contains(Language.ES);
    }

    @Test
    public void saveTest() {
        MailMessageTemplate mailMessageTemplate = MailMessageTemplate.with().type(MailMessageTemplateType.INVITATION)
                .language(Language.EN).fromAddress("support@gazpacho.net").replyTo("nonreply@gazpacho.net").build();

        MailMessageTemplateLanguageSettings languageSettings = new MailMessageTemplateLanguageSettings();
        languageSettings.setSubject("Your questionnairDefinition");
        languageSettings
                .setBody("Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"\">Click here</a> to take the questionnairDefinition");
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
        translation.setLanguage(Language.ES);
        translation.setMailMessageTemplate(mailMessageTemplate);

        mailMessageTemplate = mailMessageTemplateService.save(mailMessageTemplate);

        mailMessageTemplateService.saveTranslation(translation);

        MailMessageTemplate localizedMailMessageTemplate = mailMessageTemplateService.findOne(
                mailMessageTemplate.getId(), Language.ES);
        assertThat(localizedMailMessageTemplate.getLanguageSettings().getSubject()).isEqualTo(
                languageSettingsInSpanish.getSubject());

        translation = mailMessageTemplate.getTranslations().get(Language.ES);
        assertThat(translation.getId()).isNotNull();

        translation.getLanguageSettings().setSubject("Tu encuesta. Version 2");
        translation = mailMessageTemplateService.saveTranslation(translation);

        assertThat(translation.getCreatedBy()).isNotNull();
        assertThat(translation.getLanguageSettings().getSubject()).isEqualTo("Tu encuesta. Version 2");
    }
}

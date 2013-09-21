package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.UserDTO;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/services-context.xml" })
public class MailMessageTemplateServiceTest {

    @Autowired
    MailMessageTemplateService service;

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        userService.save(UserDTO.with().firstName("temporal.support")
                .lastName("support").email("support.temporal@gazpacho.net")
                .build());

        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .mailMessageTemplateLanguageSettingsStart()
                .subject("Your survey")
                .body("Dear Mr. ${participant.lastname}, <br> You have been invited to take this survey. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"\">Click here</a> to take the survey")
                .mailMessageTemplateLanguageSettingsEnd().build();
        mailMessageTemplate = service.save(mailMessageTemplate);

        MailMessageTemplateLanguageSettingsDTO languageSettings = MailMessageTemplateLanguageSettingsDTO
                .with()
                .subject("Tu encuesta")
                .body("Estimado Sr. ${participant.lastname}, <br> Has sido invitado para participar en esta encuesta <br>"
                        + "Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario"
                        + "<a href=\"\">Click aqui</a> para empezar").build();
        service.addTranslation(mailMessageTemplate, Language.ES,
                languageSettings);
        
       MailMessageTemplateDTO localizedMailMessageTemplate = service.findOne(mailMessageTemplate.getId(), Language.ES);
       
       System.out.println(localizedMailMessageTemplate);
    }
}

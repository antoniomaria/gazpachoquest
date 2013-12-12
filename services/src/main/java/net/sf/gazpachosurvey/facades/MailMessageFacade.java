package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;

public interface MailMessageFacade {

    MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate);

    TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> saveTranslation(
            TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation);

}

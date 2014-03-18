package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;

public interface MailMessageFacade {

    MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate);

    TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> saveTranslation(
            TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation);

}

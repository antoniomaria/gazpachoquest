package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;

public interface MailMessageTemplateService extends
        LocalizedPersistenceService<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> {

}

package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.types.Language;

public interface MailMessageTemplateService extends LocalizedPersistenceService<MailMessageTemplateDTO, Integer> {

    void addTranslation(MailMessageTemplateDTO mailMessageTemplate, Language language, MailMessageTemplateLanguageSettingsDTO languageSettings);

}

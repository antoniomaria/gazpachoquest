package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;

public interface MailMessageTemplateService extends
        LocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateLanguageSettings> {

}

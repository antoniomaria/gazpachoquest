package net.sf.gazpachoquest.services;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;

public interface MailMessageTemplateService
        extends
        LocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {

}

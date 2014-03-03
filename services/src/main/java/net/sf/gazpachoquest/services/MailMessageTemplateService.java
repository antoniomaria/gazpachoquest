package net.sf.gazpachoquest.services;

import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;

public interface MailMessageTemplateService
        extends
        LocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {

}

package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;

public interface MailMessageFacade {

    MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate);
}

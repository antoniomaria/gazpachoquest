package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class MailMessageTemplate extends AbstractAuditable<Integer> {

    private static final long serialVersionUID = 8115847063538607577L;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    public MailMessageTemplate() {
        super();
    }

}

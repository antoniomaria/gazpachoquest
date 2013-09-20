package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

public class MailMessageTemplateTranslation extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 6847847400152631889L;

    @ManyToOne
    private MailMessageTemplate mailMessageTemplate;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    public MailMessageTemplateTranslation() {
        super();
    }

}

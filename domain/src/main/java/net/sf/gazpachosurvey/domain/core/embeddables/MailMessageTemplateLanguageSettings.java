package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

@Embeddable
public class MailMessageTemplateLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -7955983562246873191L;

    private String subject;

    @Lob
    private String body;

    public MailMessageTemplateLanguageSettings() {
        super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

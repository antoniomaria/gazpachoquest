package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class MailMessageTemplateLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -7955983562246873191L;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
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

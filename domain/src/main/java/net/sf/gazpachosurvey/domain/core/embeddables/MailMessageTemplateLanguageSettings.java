package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class MailMessageTemplateLanguageSettings {

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

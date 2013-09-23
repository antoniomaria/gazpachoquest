package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class MailMessageTemplate
        extends
       AbstractLocalizable<Integer, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {
    private static final long serialVersionUID = 8115847063538607577L;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String fromAddress;

    private String replyTo;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    @OneToMany(mappedBy = "mailMessageTemplate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language")
    private Map<Language, MailMessageTemplateTranslation> translations;

    public MailMessageTemplate() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String from) {
        this.fromAddress = from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public MailMessageTemplateLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(
            MailMessageTemplateLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Map<Language, MailMessageTemplateTranslation> getTranslations() {
        if (translations == null) {
            this.translations = new HashMap<Language, MailMessageTemplateTranslation>();
        }

        return translations;
    }

    public void setTranslations(
            Map<Language, MailMessageTemplateTranslation> translations) {
        this.translations = translations;
    }

    public void addTranslation(Language language,
            MailMessageTemplateLanguageSettings languageSettings) {
        MailMessageTemplateTranslation translation = new MailMessageTemplateTranslation();
        translation.setMailMessageTemplate(this);
        translation.setLanguage(language);
        translation.setLanguageSettings(languageSettings);
        getTranslations().put(language, translation);
    }
}

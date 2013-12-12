package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;

@Entity
public class MailMessageTemplate extends
        AbstractLocalizable<MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {

    private static final long serialVersionUID = 8115847063538607577L;

    @Enumerated(EnumType.STRING)
    @Column(insertable = true, updatable = true, nullable = false)
    private MailMessageTemplateType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    private String fromAddress;

    private String replyTo;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    @OneToMany(mappedBy = "mailMessageTemplate", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, MailMessageTemplateTranslation> translations;

    public MailMessageTemplate() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String from) {
        fromAddress = from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public MailMessageTemplateLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(MailMessageTemplateLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Map<Language, MailMessageTemplateTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<Language, MailMessageTemplateTranslation>();
        }

        return translations;
    }

    public void setTranslations(Map<Language, MailMessageTemplateTranslation> translations) {
        this.translations = translations;
    }

    public void addTranslation(Language language, MailMessageTemplateTranslation translation) {
        getTranslations().put(language, translation);
        translation.setMailMessageTemplate(this);
    }

    public MailMessageTemplateType getType() {
        return type;
    }

    public void setType(MailMessageTemplateType type) {
        this.type = type;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private Survey survey;
        private MailMessageTemplateType type;
        private Language language;
        private String fromAddress;
        private String replyTo;
        private MailMessageTemplateLanguageSettings languageSettings;
        private Map<Language, MailMessageTemplateTranslation> translations;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder survey(Survey survey) {
            this.survey = survey;
            return this;
        }

        public Builder type(MailMessageTemplateType type) {
            this.type = type;
            return this;
        }

        public Builder fromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
            return this;
        }

        public Builder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public Builder languageSettings(MailMessageTemplateLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder translations(Map<Language, MailMessageTemplateTranslation> translations) {
            this.translations = translations;
            return this;
        }

        public MailMessageTemplate build() {
            MailMessageTemplate mailMessageTemplate = new MailMessageTemplate();
            mailMessageTemplate.language = language;
            mailMessageTemplate.fromAddress = fromAddress;
            mailMessageTemplate.replyTo = replyTo;
            mailMessageTemplate.languageSettings = languageSettings;
            mailMessageTemplate.translations = translations;
            mailMessageTemplate.type = type;
            mailMessageTemplate.survey = survey;
            mailMessageTemplate.setId(id);
            return mailMessageTemplate;
        }
    }
}

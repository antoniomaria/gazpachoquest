/*
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 */
package net.sf.gazpachoquest.domain.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlTransient;

import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

@SuppressWarnings("serial")
@Entity
public class MailMessageTemplate extends
        AbstractLocalizable<MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {

    @Column(insertable = true, updatable = true, nullable = false)
    @XmlTransient
    @Enumerated(EnumType.STRING)
    private MailMessageTemplateType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionnaireDefinition questionnaireDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;
    
    @Column(nullable = false)
    private String fromAddress;

    @Column(nullable = false)
    private String replyTo;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    @OneToMany(mappedBy = "mailMessageTemplate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, MailMessageTemplateTranslation> translations = new HashMap<Language, MailMessageTemplateTranslation>();

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
        return Collections.unmodifiableMap(translations);
    }

    public void addTranslation(Language language, MailMessageTemplateTranslation translation) {
        translations.put(language, translation);
        translation.setMailMessageTemplate(this);
    }

    public MailMessageTemplateType getType() {
        return type;
    }

    public void setType(MailMessageTemplateType type) {
        this.type = type;
    }

    public QuestionnaireDefinition getQuestionnairDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnairDefinition(QuestionnaireDefinition questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private QuestionnaireDefinition questionnaireDefinition;
        private MailMessageTemplateType type;
        private Language language;
        private String fromAddress;
        private String replyTo;
        private MailMessageTemplateLanguageSettings languageSettings;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder questionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
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

        public MailMessageTemplate build() {
            MailMessageTemplate mailMessageTemplate = new MailMessageTemplate();
            mailMessageTemplate.language = language;
            mailMessageTemplate.fromAddress = fromAddress;
            mailMessageTemplate.replyTo = replyTo;
            mailMessageTemplate.languageSettings = languageSettings;
            mailMessageTemplate.type = type;
            mailMessageTemplate.questionnaireDefinition = questionnaireDefinition;
            mailMessageTemplate.setId(id);
            return mailMessageTemplate;
        }
    }

    public void updateInverseRelationships() {
        for (Entry<Language, MailMessageTemplateTranslation> entry : translations.entrySet()) {
            MailMessageTemplateTranslation mailMessageTemplateTranslation = entry.getValue();
            mailMessageTemplateTranslation.setMailMessageTemplate(this);
            mailMessageTemplateTranslation.setLanguage(entry.getKey());
        }

    }
}

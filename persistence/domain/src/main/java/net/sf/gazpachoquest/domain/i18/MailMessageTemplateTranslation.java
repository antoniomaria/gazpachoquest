/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractAuditable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class MailMessageTemplateTranslation extends AbstractAuditable implements
        Translation<MailMessageTemplateLanguageSettings> {

    private static final long serialVersionUID = 6847847400152631889L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private MailMessageTemplate mailMessageTemplate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    public MailMessageTemplateTranslation() {
        super();
    }

    public MailMessageTemplate getMailMessageTemplate() {
        return mailMessageTemplate;
    }

    public void setMailMessageTemplate(MailMessageTemplate mailMessageTemplate) {
        this.mailMessageTemplate = mailMessageTemplate;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public MailMessageTemplateLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(MailMessageTemplateLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements
            TranslationBuilder<MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> {
        private MailMessageTemplate mailMessageTemplate;
        private Language language;
        private MailMessageTemplateLanguageSettings languageSettings;

        public Builder mailMessageTemplate(MailMessageTemplate mailMessageTemplate) {
            this.mailMessageTemplate = mailMessageTemplate;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(MailMessageTemplateLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public MailMessageTemplateTranslation build() {
            MailMessageTemplateTranslation mailMessageTemplateTranslation = new MailMessageTemplateTranslation();
            mailMessageTemplateTranslation.mailMessageTemplate = mailMessageTemplate;
            mailMessageTemplateTranslation.language = language;
            mailMessageTemplateTranslation.languageSettings = languageSettings;
            return mailMessageTemplateTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            mailMessageTemplate(MailMessageTemplate.with().id(entityId).build());
            return this;
        }
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getMailMessageTemplate().getId();
    }
}

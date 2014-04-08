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

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionTranslation extends AbstractPersistable implements Translation<QuestionLanguageSettings> {

    private static final long serialVersionUID = 4295351363647972048L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Question question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    @Embedded
    private QuestionLanguageSettings languageSettings;

    public QuestionTranslation() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
    public QuestionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements TranslationBuilder<QuestionTranslation, QuestionLanguageSettings> {
        private Question question;
        private Language language;
        private QuestionLanguageSettings languageSettings;

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionTranslation build() {
            QuestionTranslation questionTranslation = new QuestionTranslation();
            questionTranslation.question = question;
            questionTranslation.language = language;
            questionTranslation.languageSettings = languageSettings;
            return questionTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            Question question = new Question();
            question.setId(entityId);
            return question(question);
        }
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getQuestion().getId();
    }
}

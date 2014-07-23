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

import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionOption extends AbstractLocalizable<QuestionOptionTranslation, QuestionOptionLanguageSettings> {

    private static final long serialVersionUID = 2405587054509407178L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Question question;

    @Column(nullable = false)
    private String code;

    @Embedded
    private QuestionOptionLanguageSettings languageSettings;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "questionOption", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, QuestionOptionTranslation> translations = new HashMap<Language, QuestionOptionTranslation>();

    public QuestionOption() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public QuestionOptionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionOptionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Map<Language, QuestionOptionTranslation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private Question question;
        private String code;
        private QuestionOptionLanguageSettings languageSettings;
        private Language language;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder languageSettings(QuestionOptionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public QuestionOption build() {
            QuestionOption questionOption = new QuestionOption();
            questionOption.setId(id);
            questionOption.question = question;
            questionOption.code = code;
            questionOption.languageSettings = languageSettings;
            questionOption.language = language;
            return questionOption;
        }
    }

    public void updateInverseRelationships() {
        for (Entry<Language, QuestionOptionTranslation> entry : translations.entrySet()) {
            QuestionOptionTranslation questionTranslation = entry.getValue();
            questionTranslation.setQuestionOption(this);
            questionTranslation.setLanguage(entry.getKey());
        }

    }

    public void translateTo(Language language) {
        QuestionOptionTranslation translation = translations.get(language);
        if (translation != null) {
            languageSettings = translation.getLanguageSettings();
            this.language = language;
        }

    }
}

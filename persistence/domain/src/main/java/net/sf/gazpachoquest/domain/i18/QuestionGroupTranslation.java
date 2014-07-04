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
import javax.xml.bind.annotation.XmlTransient;

import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionGroupTranslation extends AbstractPersistable implements Translation<QuestionGroupLanguageSettings> {

    private static final long serialVersionUID = -2719163699375812306L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionGroup questionGroup;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Language language;

    @Embedded
    private QuestionGroupLanguageSettings languageSettings;

    public QuestionGroupTranslation() {
        super();
    }

    public QuestionGroup getQuestionGroup() {
        if (questionGroup == null) {
            return new QuestionGroup();
        }
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
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
    public QuestionGroupLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionGroupLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements TranslationBuilder<QuestionGroupTranslation, QuestionGroupLanguageSettings> {
        private QuestionGroup questionGroup;
        private Language language;
        private QuestionGroupLanguageSettings languageSettings;

        public Builder questionGroup(QuestionGroup questionGroup) {
            this.questionGroup = questionGroup;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionGroupLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionGroupTranslation build() {
            QuestionGroupTranslation questionGroupTranslation = new QuestionGroupTranslation();
            questionGroupTranslation.questionGroup = questionGroup;
            questionGroupTranslation.language = language;
            questionGroupTranslation.languageSettings = languageSettings;
            return questionGroupTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setId(entityId);
            return questionGroup(questionGroup);
        }
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getQuestionGroup().getId();
    }
}

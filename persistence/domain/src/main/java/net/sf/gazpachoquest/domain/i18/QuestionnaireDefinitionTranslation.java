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

import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionnaireDefinitionTranslation extends AbstractPersistable implements
        Translation<QuestionnaireDefinitionLanguageSettings> {

    private static final long serialVersionUID = -1926161817588270977L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionnaireDefinition questionnaireDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Language language;

    @Embedded
    private QuestionnaireDefinitionLanguageSettings languageSettings;

    public QuestionnaireDefinitionTranslation() {
        super();
    }

    public QuestionnaireDefinition getQuestionnairDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnairDefinition(QuestionnaireDefinition questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
    }

    @Override
    public QuestionnaireDefinitionLanguageSettings getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionnaireDefinitionLanguageSettings();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionnaireDefinitionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Language getLanguage() {

        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder implements
            TranslationBuilder<QuestionnaireDefinitionTranslation, QuestionnaireDefinitionLanguageSettings> {
        private QuestionnaireDefinition questionnaireDefinition;
        private Language language;
        private QuestionnaireDefinitionLanguageSettings languageSettings;
        private Integer id;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder questionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionnaireDefinitionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionnaireDefinitionTranslation build() {
            QuestionnaireDefinitionTranslation questionnaireDefinitionTranslation = new QuestionnaireDefinitionTranslation();
            questionnaireDefinitionTranslation.questionnaireDefinition = questionnaireDefinition;
            questionnaireDefinitionTranslation.language = language;
            questionnaireDefinitionTranslation.languageSettings = languageSettings;
            questionnaireDefinitionTranslation.setId(id);
            return questionnaireDefinitionTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            return questionnaireDefinition(QuestionnaireDefinition.with().id(entityId).build());
        }

    }

    @Override
    public Integer getTranslatedEntityId() {
        // TODO Auto-generated method stub
        return null;
    }
}

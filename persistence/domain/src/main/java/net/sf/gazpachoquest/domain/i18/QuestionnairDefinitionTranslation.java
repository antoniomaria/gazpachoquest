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

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionnairDefinitionTranslation extends AbstractPersistable implements
        Translation<QuestionnairDefinitionLanguageSettings> {

    private static final long serialVersionUID = -1926161817588270977L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionnairDefinition questionnairDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Language language;

    @Embedded
    private QuestionnairDefinitionLanguageSettings languageSettings;

    public QuestionnairDefinitionTranslation() {
        super();
    }

    public QuestionnairDefinition getQuestionnairDefinition() {
        return questionnairDefinition;
    }

    public void setQuestionnairDefinition(QuestionnairDefinition questionnairDefinition) {
        this.questionnairDefinition = questionnairDefinition;
    }

    @Override
    public QuestionnairDefinitionLanguageSettings getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionnairDefinitionLanguageSettings();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
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

    public static class Builder implements
            TranslationBuilder<QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {
        private QuestionnairDefinition questionnairDefinition;
        private Language language;
        private QuestionnairDefinitionLanguageSettings languageSettings;
        private Integer id;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder questionnairDefinition(QuestionnairDefinition questionnairDefinition) {
            this.questionnairDefinition = questionnairDefinition;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionnairDefinitionTranslation build() {
            QuestionnairDefinitionTranslation questionnairDefinitionTranslation = new QuestionnairDefinitionTranslation();
            questionnairDefinitionTranslation.questionnairDefinition = questionnairDefinition;
            questionnairDefinitionTranslation.language = language;
            questionnairDefinitionTranslation.languageSettings = languageSettings;
            questionnairDefinitionTranslation.setId(id);
            return questionnairDefinitionTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            return questionnairDefinition(QuestionnairDefinition.with().id(entityId).build());
        }

    }

    @Override
    public Integer getTranslatedEntityId() {
        // TODO Auto-generated method stub
        return null;
    }
}

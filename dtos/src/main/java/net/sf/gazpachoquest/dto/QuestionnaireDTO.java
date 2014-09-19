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
package net.sf.gazpachoquest.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.Language;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuestionnaireDTO", description = "Questionnair resource representation")
public class QuestionnaireDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = 1067156345771109606L;

    @ApiModelProperty(value = "Default language", required = true)
    private Language language;

    @ApiModelProperty(value = "Others languages supported", required = false)
    private final Set<Language> supportedLanguages = new HashSet<Language>();

    private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;

    private Boolean welcomeVisible;

    private Boolean progressVisible;

    private Boolean sectionInfoVisible;

    public QuestionnaireDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Language> getSupportedLanguages() {
        return Collections.unmodifiableSet(supportedLanguages);
    }

    public void addSupportedLanguage(Language language) {
        supportedLanguages.add(language);
    }

    public QuestionnaireDefinitionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionnaireDefinitionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Boolean isWelcomeVisible() {
        return welcomeVisible;
    }

    public void setWelcomeVisible(Boolean welcomeVisible) {
        this.welcomeVisible = welcomeVisible;
    }

    public Boolean isProgressVisible() {
        return progressVisible;
    }

    public void setProgressVisible(Boolean progressVisible) {
        this.progressVisible = progressVisible;
    }

    public Boolean isSectionInfoVisible() {
        return sectionInfoVisible;
    }

    public void setSectionInfoVisible(Boolean sectionInfoVisible) {
        this.sectionInfoVisible = sectionInfoVisible;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private Language language;
        private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;
        private Boolean welcomeVisible;
        private Boolean progressVisible;
        private Boolean sectionInfoVisible;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder welcomeVisible(Boolean welcomeVisible) {
            this.welcomeVisible = welcomeVisible;
            return this;
        }

        public Builder progressVisible(Boolean progressVisible) {
            this.progressVisible = progressVisible;
            return this;
        }

        public Builder sectionInfoVisible(Boolean sectionInfoVisible) {
            this.sectionInfoVisible = sectionInfoVisible;
            return this;
        }

        public Builder languageSettings(QuestionnaireDefinitionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public QuestionnaireDTO build() {
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
            questionnaireDTO.setId(id);
            questionnaireDTO.language = language;
            questionnaireDTO.languageSettings = languageSettings;
            questionnaireDTO.welcomeVisible = welcomeVisible;
            questionnaireDTO.progressVisible = progressVisible;
            questionnaireDTO.sectionInfoVisible = sectionInfoVisible;
            return questionnaireDTO;
        }
    }
}

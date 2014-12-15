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
package net.sf.gazpachoquest.dto.embeddables;

import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.support.LanguageSettingsDTO;

import com.wordnik.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(value = "QuestionnaireDefinitionLanguageSettingsDTO", description = "Container for all text content inside the questionnair")
public class QuestionnaireDefinitionLanguageSettingsDTO implements LanguageSettingsDTO {

    private String description;

    private String title;

    private String welcomeText;

    private String endText;

    public QuestionnaireDefinitionLanguageSettingsDTO() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getEndText() {
        return endText;
    }

    public void setEndText(String endText) {
        this.endText = endText;
    }

    public void setWelcomeText(final String welcomeText) {
        this.welcomeText = welcomeText;
    }

    @Override
    public String toString() {
        return "QuestionnaireDefinitionLanguageSettingsDTO [title=" + title + ", description=" + description
                + ", welcomeText=" + welcomeText + "]";
    }

    public static interface Builder {

        QuestionnaireDefinitionLanguageSettingsDTO build();

        Builder description(String description);

        QuestionnaireDefinitionDTO.Builder questionnairLanguageSettingsEnd();

        Builder title(String title);

        Builder endText(String endText);

        Builder welcomeText(String welcomeText);

    }

    public static class BuilderImpl implements Builder {
        private final QuestionnaireDefinitionDTO.Builder container;
        private String description = "";
        private String title;
        private String welcomeText = "";
        private String endText = "";

        public BuilderImpl(final QuestionnaireDefinitionDTO.Builder container) {
            this.container = container;
        }

        @Override
        public QuestionnaireDefinitionLanguageSettingsDTO build() {
            QuestionnaireDefinitionLanguageSettingsDTO questionnaireDefinitionLanguageSettingsDTO = new QuestionnaireDefinitionLanguageSettingsDTO();
            questionnaireDefinitionLanguageSettingsDTO.title = title;
            questionnaireDefinitionLanguageSettingsDTO.description = description;
            questionnaireDefinitionLanguageSettingsDTO.welcomeText = welcomeText;
            questionnaireDefinitionLanguageSettingsDTO.endText = endText;
            return questionnaireDefinitionLanguageSettingsDTO;
        }

        @Override
        public BuilderImpl description(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public QuestionnaireDefinitionDTO.Builder questionnairLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public BuilderImpl title(final String title) {
            this.title = title;
            return this;
        }

        @Override
        public BuilderImpl welcomeText(final String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }

        @Override
        public Builder endText(String endText) {
            this.endText = endText;
            return this;
        }
    }

    public static Builder surveyLanguageSettingsStart(final QuestionnaireDefinitionDTO.Builder container) {
        return new QuestionnaireDefinitionLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

}

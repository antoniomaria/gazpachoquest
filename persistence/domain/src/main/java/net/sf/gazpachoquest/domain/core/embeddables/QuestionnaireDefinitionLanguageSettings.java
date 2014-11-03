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
package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class QuestionnaireDefinitionLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -4067256922719049044L;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Lob
    @Column(nullable = false)
    private String welcomeText;

    @Lob
    @Column(nullable = false)
    private String endText;

    public QuestionnaireDefinitionLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public String getEndText() {
        return endText;
    }

    public void setEndText(String endText) {
        this.endText = endText;
    }

    public static Builder with() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof QuestionnaireDefinitionLanguageSettings) {
            final QuestionnaireDefinitionLanguageSettings other = (QuestionnaireDefinitionLanguageSettings) obj;
            return EqualsBuilder.reflectionEquals(this, other);
        } else {
            return false;
        }
    }

    public static class Builder {
        private String title;
        private String description;
        private String welcomeText;
        private String endText;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder welcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }

        public Builder endText(String endText) {
            this.endText = endText;
            return this;
        }

        public QuestionnaireDefinitionLanguageSettings build() {
            QuestionnaireDefinitionLanguageSettings questionnaireDefinitionLanguageSettings = new QuestionnaireDefinitionLanguageSettings();
            questionnaireDefinitionLanguageSettings.title = title;
            questionnaireDefinitionLanguageSettings.description = description;
            questionnaireDefinitionLanguageSettings.welcomeText = welcomeText;
            questionnaireDefinitionLanguageSettings.endText = endText;
            return questionnaireDefinitionLanguageSettings;
        }
    }
}

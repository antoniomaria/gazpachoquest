package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import net.sf.gazpachosurvey.types.Language;

@Embeddable
public class SurveyLanguageSettings {

    private String title;

    private String description;

    public SurveyLanguageSettings() {
        super();
    }

    public SurveyLanguageSettings(String title,
            String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public SurveyLanguageSettings(Builder builder) {
        super();
        this.title = builder.title;
        this.description = builder.description;
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

    public static class Builder {
        private String title;

        private String description;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public SurveyLanguageSettings build() {
            return new SurveyLanguageSettings(this);
        }
    }

}

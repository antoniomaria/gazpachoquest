package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class SurveyLanguageSettings {

    private String title;

    @Lob
    private String description;

    @Lob
    private String welcomeText;

    public SurveyLanguageSettings() {
        super();
    }

    public SurveyLanguageSettings(String title, String description, String welcomeText) {
        super();
        this.title = title;
        this.description = description;
        this.welcomeText = welcomeText;
    }

    public SurveyLanguageSettings(Builder builder) {
        super();
        title = builder.title;
        description = builder.description;
        welcomeText = builder.welcomeText;
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

    public static class Builder {
        private String title;

        private String description;

        private String welcomeText;

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

        public SurveyLanguageSettings build() {
            return new SurveyLanguageSettings(this);
        }
    }

}

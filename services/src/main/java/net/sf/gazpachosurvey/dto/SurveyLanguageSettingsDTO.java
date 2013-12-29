package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class SurveyLanguageSettingsDTO implements LanguageSettings {

    public static interface Builder {

        SurveyLanguageSettingsDTO build();

        Builder description(String description);

        SurveyDTO.Builder surveyLanguageSettingsEnd();

        Builder title(String title);

        Builder welcomeText(String welcomeText);

    }

    public static class BuilderImpl implements Builder {
        private String title;
        private String description;
        private String welcomeText;
        private final SurveyDTO.Builder container;

        public BuilderImpl(final SurveyDTO.Builder container) {
            this.container = container;
        }

        @Override
        public SurveyLanguageSettingsDTO build() {
            SurveyLanguageSettingsDTO surveyLanguageSettingsDTO = new SurveyLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            surveyLanguageSettingsDTO.description = description;
            surveyLanguageSettingsDTO.welcomeText = welcomeText;
            return surveyLanguageSettingsDTO;
        }

        @Override
        public BuilderImpl description(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public SurveyDTO.Builder surveyLanguageSettingsEnd() {
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
    }

    private static final long serialVersionUID = 3452734192681766764L;

    public static Builder surveyLanguageSettingsStart(final SurveyDTO.Builder container) {
        return new SurveyLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    private String title;

    private String description;

    private String welcomeText;

    public SurveyLanguageSettingsDTO() {
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

    public void setWelcomeText(final String welcomeText) {
        this.welcomeText = welcomeText;
    }

    @Override
    public String toString() {
        return "SurveyLanguageSettingsDTO [title=" + title + ", description=" + description + ", welcomeText="
                + welcomeText + "]";
    }

}

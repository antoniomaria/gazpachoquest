package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class SurveyLanguageSettingsDTO implements LanguageSettings {

    private static final long serialVersionUID = 3452734192681766764L;

    private String title;

    private String description;

    private String welcomeText;

    public SurveyLanguageSettingsDTO() {
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

    public static Builder surveyLanguageSettingsStart(
            SurveyDTO.Builder container) {
        return new SurveyLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        Builder title(String title);

        Builder description(String description);

        Builder welcomeText(String welcomeText);

        SurveyDTO.Builder surveyLanguageSettingsEnd();

        SurveyLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {
        private String title;
        private String description;
        private String welcomeText;
        private final SurveyDTO.Builder container;

        public BuilderImpl(SurveyDTO.Builder container) {
            this.container = container;
        }

        @Override
        public BuilderImpl title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public BuilderImpl description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public BuilderImpl welcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }

        @Override
        public SurveyDTO.Builder surveyLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public SurveyLanguageSettingsDTO build() {
            SurveyLanguageSettingsDTO surveyLanguageSettingsDTO = new SurveyLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            surveyLanguageSettingsDTO.description = description;
            surveyLanguageSettingsDTO.welcomeText = welcomeText;
            return surveyLanguageSettingsDTO;
        }
    }
}

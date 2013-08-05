package net.sf.gazpachosurvey.dto;

public class SurveyLanguageSettingsDTO {

    private String title;

    private String description;

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

    public static Builder surveyLanguageSettingsStart(SurveyDTO.Builder container) {
        return new SurveyLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        Builder title(String title);

        Builder description(String description);

        SurveyDTO.Builder surveyLanguageSettingsEnd();

        SurveyLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {
        private String title;
        private String description;
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
        public SurveyDTO.Builder surveyLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public SurveyLanguageSettingsDTO build() {
            SurveyLanguageSettingsDTO surveyLanguageSettingsDTO = new SurveyLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            surveyLanguageSettingsDTO.description = description;
            return surveyLanguageSettingsDTO;
        }
    }
}

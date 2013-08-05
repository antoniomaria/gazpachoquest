package net.sf.gazpachosurvey.dto;

public class SurveyDTO extends AbstractSerializableDTO<Integer> {

    private SurveyLanguageSettingsDTO languageSettings;

    public SurveyDTO() {
        super();
    }

    public SurveyLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(SurveyLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static interface Builder {
        Builder languageSettings(SurveyLanguageSettingsDTO languageSettings);

        SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart();

        SurveyDTO build();
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static class BuilderImpl implements Builder {
        private SurveyLanguageSettingsDTO languageSettings;

        @Override
        public BuilderImpl languageSettings(SurveyLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart() {
            return SurveyLanguageSettingsDTO.surveyLanguageSettingsStart(this);
        }

        @Override
        public SurveyDTO build() {
            SurveyDTO surveyDTO = new SurveyDTO();
            surveyDTO.languageSettings = languageSettings;
            return surveyDTO;
        }
    }
}

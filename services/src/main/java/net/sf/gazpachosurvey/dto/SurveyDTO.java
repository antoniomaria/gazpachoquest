package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.types.Language;

public class SurveyDTO extends AbstractSerializableDTO<Integer> {

    private static final long serialVersionUID = 4558625807621395019L;

    private Language language;
    
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public static interface Builder {
        Builder languageSettings(SurveyLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart();

        SurveyDTO build();
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static class BuilderImpl implements Builder {
        private Language language;
        
        private SurveyLanguageSettingsDTO languageSettings;
        
        @Override
        public BuilderImpl language(Language language) {
            this.language = language;
            return this;
        }
        
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
            surveyDTO.language = language;
            return surveyDTO;
        }
    }
}

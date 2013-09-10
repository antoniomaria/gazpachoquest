package net.sf.gazpachosurvey.dto;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.types.Language;

public class SurveyDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = 4558625807621395019L;

    private Language language;
    
    private SurveyLanguageSettingsDTO languageSettings;
    
    private Set<Question> questions;

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
    
    public Set<Question> getQuestions() {
        if (questions == null){
            this.questions = new HashSet<>();
        }
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public static interface Builder {
        Builder id(Integer id);
        
        Builder languageSettings(SurveyLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart();

        SurveyDTO build();
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;
        
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
            surveyDTO.setId(id);
            return surveyDTO;
        }

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
    }
}

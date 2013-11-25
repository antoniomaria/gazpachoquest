package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class SurveyDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<SurveyLanguageSettingsDTO>{

    private static final long serialVersionUID = 4558625807621395019L;

    private Language language;

    private SurveyLanguageSettingsDTO languageSettings;

    private List<QuestionGroupDTO> questionGroups;
    
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
    
    public void addQuestionGroup(QuestionGroupDTO questionGroup) {
    	questionGroup.setSurvey(this);
        getQuestionGroups().add(questionGroup);
    }
    public QuestionGroupDTO getLastQuestionGroupDTO(){
        int count = getQuestionGroups().size();
        return count > 0 ? getQuestionGroups().get(count-1) : null;
    }

    public List<QuestionGroupDTO> getQuestionGroups() {
        if (questionGroups == null){
            questionGroups = new ArrayList<>();
        }
        return questionGroups;
    }

    public void setQuestionGroups(List<QuestionGroupDTO> questionGroups) {
        this.questionGroups = questionGroups;
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

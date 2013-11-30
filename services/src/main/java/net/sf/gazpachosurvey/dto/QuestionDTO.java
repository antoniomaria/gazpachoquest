package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public class QuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO> {

    private static final long serialVersionUID = 2663159055152157679L;

    private Boolean isRequired;

    private QuestionType type;

    private Language language;

    private List<QuestionDTO> subquestions;

    private List<QuestionOptionDTO> questionOptions;

    private QuestionLanguageSettingsDTO languageSettings;

    public QuestionDTO() {
        super();
    }

    public Boolean isRequired() {
        return isRequired;
    }

    public void setRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<QuestionDTO> getSubquestions() {
        if (subquestions == null) {
            subquestions = new ArrayList<QuestionDTO>();
        }
        return subquestions;
    }


    public void addSubQuestion(QuestionDTO subQuestion) {
        if (!getSubquestions().contains(subQuestion)){
            subquestions.add(subQuestion);    
        }
    }

    public List<QuestionOptionDTO> getQuestionOptions() {
        if (questionOptions == null) {
            questionOptions = new ArrayList<>();
        }
        return questionOptions;
    }

    public void addQuestionOption(QuestionOptionDTO questionOption) {
        if (!getQuestionOptions().contains(questionOption)){
            questionOptions.add(questionOption);    
        }
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public QuestionLanguageSettingsDTO getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettingsDTO();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {
        Builder id(Integer id);

        Builder type(QuestionType type);

        Builder languageSettings(QuestionLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        Builder subquestions(List<QuestionDTO> subquestions);

        Builder answers(List<QuestionOptionDTO> answers);

        Builder isRequired(Boolean isRequired);

        QuestionLanguageSettingsDTO.Builder languageSettingsStart();

        QuestionDTO build();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;
        private Boolean isRequired;
        private QuestionType type;
        private Language language;
        private List<QuestionDTO> subquestions;
        private List<QuestionOptionDTO> answers;
        private QuestionLanguageSettingsDTO languageSettings;

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        
        @Override
        public Builder isRequired(Boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        @Override
        public Builder type(QuestionType type) {
            this.type = type;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder subquestions(List<QuestionDTO> subquestions) {
            this.subquestions = subquestions;
            return this;
        }

        @Override
        public Builder answers(List<QuestionOptionDTO> answers) {
            this.answers = answers;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionLanguageSettingsDTO.Builder languageSettingsStart() {
            return QuestionLanguageSettingsDTO.languageSettingsStart(this);
        }

        @Override
        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(id);
            questionDTO.isRequired = isRequired;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.subquestions = subquestions;
            questionDTO.questionOptions = answers;
            questionDTO.languageSettings = languageSettings;
            return questionDTO;
        }
    }

}

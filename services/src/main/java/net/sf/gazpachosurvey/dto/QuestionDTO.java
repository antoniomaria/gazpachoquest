package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public class QuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO> {

    private static final long serialVersionUID = 2663159055152157679L;

    private SurveyDTO survey;

    private QuestionGroupDTO page;

    private Boolean isRequired;

    private QuestionType type;

    private Language language;

    private List<QuestionDTO> subquestions;

    private List<AnswerDTO> answers;

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<QuestionDTO> getSubquestions() {
        if (subquestions == null) {
            subquestions = new ArrayList<QuestionDTO>();
        }
        return subquestions;
    }

    public void setSubquestions(List<QuestionDTO> subquestions) {
        this.subquestions = subquestions;
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
        if (survey.getLanguage() != null) {
            language = survey.getLanguage();
        }
    }

    public QuestionGroupDTO getPage() {
        return page;
    }

    public void setPage(QuestionGroupDTO page) {
        this.page = page;
    }

    public List<AnswerDTO> getAnswers() {
        if (answers == null) {
            answers = new ArrayList<>();
        }
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public void addAnswer(AnswerDTO answer) {
        if (answer.getLanguage() == null) {
            answer.setLanguage(language);
        }
        getAnswers().add(answer);
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public QuestionLanguageSettingsDTO getLanguageSettings() {
        if (languageSettings == null) {
            this.languageSettings = new QuestionLanguageSettingsDTO();
        }
        return languageSettings;
    }

    public void setLanguageSettings(QuestionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {
        Builder id(Integer id);

        Builder type(QuestionType type);

        Builder page(QuestionGroupDTO page);

        Builder survey(SurveyDTO survey);

        Builder languageSettings(QuestionLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        Builder subquestions(List<QuestionDTO> subquestions);

        Builder answers(List<AnswerDTO> answers);

        Builder isRequired(Boolean isRequired);

        QuestionLanguageSettingsDTO.Builder languageSettingsStart();

        QuestionDTO build();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;
        private SurveyDTO survey;
        private QuestionGroupDTO page;
        private Boolean isRequired;
        private QuestionType type;
        private Language language;
        private List<QuestionDTO> subquestions;
        private List<AnswerDTO> answers;
        private QuestionLanguageSettingsDTO languageSettings;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder survey(SurveyDTO survey) {
            this.survey = survey;
            return this;
        }

        public Builder page(QuestionGroupDTO page) {
            this.page = page;
            return this;
        }

        public Builder isRequired(Boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public Builder type(QuestionType type) {
            this.type = type;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder subquestions(List<QuestionDTO> subquestions) {
            this.subquestions = subquestions;
            return this;
        }

        public Builder answers(List<AnswerDTO> answers) {
            this.answers = answers;
            return this;
        }

        public Builder languageSettings(
                QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public QuestionLanguageSettingsDTO.Builder languageSettingsStart() {
            return QuestionLanguageSettingsDTO.languageSettingsStart(this);
        }

        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(id);
            questionDTO.survey = survey;
            questionDTO.page = page;
            questionDTO.isRequired = isRequired;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.subquestions = subquestions;
            questionDTO.answers = answers;
            questionDTO.languageSettings = languageSettings;
            return questionDTO;
        }
    }

}

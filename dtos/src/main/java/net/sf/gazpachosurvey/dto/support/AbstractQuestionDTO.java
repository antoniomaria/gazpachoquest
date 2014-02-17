package net.sf.gazpachosurvey.dto.support;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionDTO;
import net.sf.gazpachosurvey.dto.answers.AbstractAnswer;
import net.sf.gazpachosurvey.dto.answers.Answer;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public abstract class AbstractQuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO> {

    private static final long serialVersionUID = 7798904943703068684L;

    protected String code;

    protected boolean required;

    protected Language language;

    protected QuestionLanguageSettingsDTO languageSettings;

    protected List<QuestionOptionDTO> questionOptions;

    protected QuestionType type;

    protected Answer answer;

    protected AbstractQuestionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addQuestionOption(final QuestionOptionDTO questionOption) {
        if (!getQuestionOptions().contains(questionOption)) {
            questionOptions.add(questionOption);
        }
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionLanguageSettingsDTO getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettingsDTO();
        }
        return languageSettings;
    }

    public List<QuestionOptionDTO> getQuestionOptions() {
        if (questionOptions == null) {
            questionOptions = new ArrayList<>();
        }
        return questionOptions;
    }

    public QuestionType getType() {
        return type;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setRequired(final Boolean isRequired) {
        required = isRequired;
    }

    public void setType(final QuestionType type) {
        this.type = type;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(AbstractAnswer answer) {
        this.answer = answer;
    }

}

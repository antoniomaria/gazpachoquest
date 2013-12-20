package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class QuestionOptionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionOptionLanguageSettingsDTO> {

    private static final long serialVersionUID = -6363290184354303253L;

    private String code;

    private QuestionOptionLanguageSettingsDTO languageSettings;

    private Language language;

    public QuestionOptionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public QuestionOptionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionOptionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String code;
        private String title;
        private Language language;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public QuestionOptionDTO build() {
            QuestionOptionDTO questionOptionDTO = new QuestionOptionDTO();
            questionOptionDTO.code = code;
            questionOptionDTO.languageSettings = new QuestionOptionLanguageSettingsDTO();
            questionOptionDTO.languageSettings.setTitle(title);
            questionOptionDTO.language = language;
            return questionOptionDTO;
        }
    }
}

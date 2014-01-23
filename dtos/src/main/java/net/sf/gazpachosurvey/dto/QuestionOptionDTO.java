package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class QuestionOptionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionOptionLanguageSettingsDTO> {

    public static class Builder {
        private String code;
        private Language language;
        private String title;

        public QuestionOptionDTO build() {
            QuestionOptionDTO questionOptionDTO = new QuestionOptionDTO();
            questionOptionDTO.code = code;
            questionOptionDTO.languageSettings = new QuestionOptionLanguageSettingsDTO();
            questionOptionDTO.languageSettings.setTitle(title);
            questionOptionDTO.language = language;
            return questionOptionDTO;
        }

        public Builder code(final String code) {
            this.code = code;
            return this;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }
    }

    private static final long serialVersionUID = -6363290184354303253L;

    public static Builder with() {
        return new Builder();
    }

    private String code;

    private Language language;

    private QuestionOptionLanguageSettingsDTO languageSettings;

    public QuestionOptionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionOptionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionOptionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }
}

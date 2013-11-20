package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

import net.sf.gazpachosurvey.types.Language;

public class QuestionOptionDTO implements Serializable {

    private static final long serialVersionUID = -6363290184354303253L;

    private String code;

    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
            questionOptionDTO.title = title;
            questionOptionDTO.language = language;
            return questionOptionDTO;
        }
    }
}

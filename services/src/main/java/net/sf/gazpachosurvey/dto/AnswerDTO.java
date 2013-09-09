package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.types.Language;

public class AnswerDTO {

    private String code;

    private String title;

    private Language language;

    public AnswerDTO() {
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
        
        public AnswerDTO build() {
            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.code = code;
            answerDTO.title = title;
            answerDTO.language = language;
            return answerDTO;
        }
    }
}

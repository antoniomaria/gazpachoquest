package net.sf.gazpachosurvey.dto;

public class AnswerDTO {

    private String code;

    private String title;

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

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String code;
        private String title;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public AnswerDTO build() {
            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.code = code;
            answerDTO.title = title;
            return answerDTO;
        }
    }
}

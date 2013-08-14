package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public class QuestionDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = 2663159055152157679L;

    private String title;

    boolean isRequired;

    private QuestionType type;

    private Language language;

    public QuestionDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
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

    public static Builder with(){
        return new Builder();
    }
    
    public static class Builder {
        private String title;
        private boolean isRequired;
        private QuestionType type;
        private Language language;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder isRequired(boolean isRequired) {
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

        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.title = title;
            questionDTO.isRequired = isRequired;
            questionDTO.type = type;
            questionDTO.language = language;
            return questionDTO;
        }
    }
}

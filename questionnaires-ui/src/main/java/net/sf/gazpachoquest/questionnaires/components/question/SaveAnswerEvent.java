package net.sf.gazpachoquest.questionnaires.components.question;

import net.sf.gazpachoquest.dto.answers.Answer;

public class SaveAnswerEvent {

    private String questionCode;
    private Answer answer;

    public SaveAnswerEvent() {
        super();
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String questionCode;
        private Answer answer;

        public Builder questionCode(String questionCode) {
            this.questionCode = questionCode;
            return this;
        }

        public Builder answer(Answer answer) {
            this.answer = answer;
            return this;
        }

        public SaveAnswerEvent build() {
            SaveAnswerEvent saveAnswerEvent = new SaveAnswerEvent();
            saveAnswerEvent.questionCode = questionCode;
            saveAnswerEvent.answer = answer;
            return saveAnswerEvent;
        }
    }
}

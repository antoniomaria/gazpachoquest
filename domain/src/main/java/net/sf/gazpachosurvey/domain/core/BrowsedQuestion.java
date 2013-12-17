package net.sf.gazpachosurvey.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.BrowsedElement.Builder;

@Entity
@DiscriminatorValue("G")
public class BrowsedQuestion extends BrowsedElement {

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public BrowsedQuestion() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public static class Builder {
        private Question question;

        private Respondent respondent;

        public Builder respondent(Respondent respondent) {
            this.respondent = respondent;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public BrowsedQuestion build() {
            BrowsedQuestion browsedQuestion = new BrowsedQuestion();
            browsedQuestion.question = question;
            browsedQuestion.respondent = respondent;
            return browsedQuestion;
        }
    }
}

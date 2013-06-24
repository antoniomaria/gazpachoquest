package net.sf.gazpachosurvey.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class ResponseOption extends AbstractPersistable<Integer> {

    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}

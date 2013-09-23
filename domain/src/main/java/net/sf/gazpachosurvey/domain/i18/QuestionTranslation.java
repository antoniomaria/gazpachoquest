package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class QuestionTranslation extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 4295351363647972048L;

    @ManyToOne
    private Question question;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    private String text;

    public QuestionTranslation() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "QuestionTranslation [text=" + text + "]";
    }

}

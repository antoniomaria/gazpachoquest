package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Answer;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class AnswerTranslation extends AbstractPersistable {

    private static final long serialVersionUID = 5809899129770049770L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    private String text;

    public AnswerTranslation() {
        super();
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
        return "AnswerTranslation [text=" + text + "]";
    }

}

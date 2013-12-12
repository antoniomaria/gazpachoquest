package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class AnswerTranslation extends AbstractPersistable {

    private static final long serialVersionUID = 5809899129770049770L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionOption questionOption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    private String text;

    public AnswerTranslation() {
        super();
    }

    public QuestionOption getAnswer() {
        return questionOption;
    }

    public void setAnswer(QuestionOption questionOption) {
        this.questionOption = questionOption;
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

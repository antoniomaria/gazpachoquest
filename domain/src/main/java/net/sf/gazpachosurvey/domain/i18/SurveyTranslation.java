package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class SurveyTranslation extends AbstractPersistable<Integer> {

    @ManyToOne
    private Survey survey;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;
    
    private String text;

    public SurveyTranslation() {
        super();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
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
        return "SurveyTranslation [text=" + text + "]";
    }

}

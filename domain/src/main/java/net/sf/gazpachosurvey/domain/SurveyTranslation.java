package net.sf.gazpachosurvey.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class SurveyTranslation extends AbstractPersistable<Integer> {

    private Survey survey;

    private String text;
    
    private Language language;

    
    
   //private Language language;
    @ManyToOne
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
    @Enumerated(EnumType.STRING)
    @Column(insertable=false, updatable=false)
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
/*
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }  
  */  
}

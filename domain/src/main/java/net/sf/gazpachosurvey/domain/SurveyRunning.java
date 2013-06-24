package net.sf.gazpachosurvey.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.NamedEntity;

@Entity
public class SurveyRunning extends NamedEntity<Integer> {

    private Survey survey;

    public SurveyRunning() {
        super();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "SurveyRunning [getId()=" + getId() + ", getName()=" + getName()
                + ", getSurvey()=" + getSurvey() + "]";
    }

}

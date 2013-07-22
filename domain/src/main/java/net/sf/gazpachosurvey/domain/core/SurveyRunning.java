package net.sf.gazpachosurvey.domain.core;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.NamedEntity;

@Entity
public class SurveyRunning extends NamedEntity<Integer> {

    private Survey survey;

    private Set<Participant> participants;

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

    @ManyToMany
    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "SurveyRunning [getId()=" + getId() + ", getName()=" + getName()
                + ", getSurvey()=" + getSurvey() + "]";
    }

}

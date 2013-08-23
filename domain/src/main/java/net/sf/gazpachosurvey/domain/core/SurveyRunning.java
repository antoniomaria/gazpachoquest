package net.sf.gazpachosurvey.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;

import org.springframework.util.Assert;

@Entity
public class SurveyRunning extends AbstractAuditable<Integer> {

    private static final long serialVersionUID = -5917291757324504802L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Survey survey;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "surveyrunning_participant", joinColumns = { @JoinColumn(name = "surveyrunning_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "participant_id", referencedColumnName = "id") })
    private Set<Participant> participants;
    
    private String name;

    public SurveyRunning() {
        super();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Set<Participant> getParticipants() {
        if (participants == null) {
            this.participants = new HashSet<>();
        }
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        for (Participant participant : participants) {
            addParticipant(participant);
        }
        System.err.println("llamado!!");
        System.err.println("llamado!!");
        System.err.println("llamado!!");
        System.err.println("llamado!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addParticipant(Participant participant) {
        Assert.notNull(participant, "Participant must be not null");
        participant.getSurveyRunnings().add(this);
        getParticipants().add(participant);
    }

    @Override
    public String toString() {
        return "SurveyRunning [getId()=" + getId() + ", getName()=" + getName()
                + ", getSurvey()=" + getSurvey() + "]";
    }

}

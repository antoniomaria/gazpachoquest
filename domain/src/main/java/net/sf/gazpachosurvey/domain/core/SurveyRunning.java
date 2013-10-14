package net.sf.gazpachosurvey.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.types.SurveyRunningType;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;
import org.springframework.util.Assert;

@Entity
public class SurveyRunning extends AbstractAuditable {

    private static final long serialVersionUID = -5917291757324504802L;

    private String name;

    @Enumerated(EnumType.STRING)
    private SurveyRunningType type;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime startDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "surveyrunning_participant", joinColumns = { @JoinColumn(name = "surveyrunning_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "participant_id", referencedColumnName = "id") })
    private Set<Participant> participants;

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
            participants = new HashSet<>();
        }
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SurveyRunningType getType() {
        return type;
    }

    public void setType(SurveyRunningType type) {
        this.type = type;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void addParticipant(Participant participant) {
        Assert.notNull(participant, "Participant must be not null");
        participant.getSurveyRunnings().add(this);
        getParticipants().add(participant);
    }

    @Override
    public String toString() {
        return "SurveyRunning [getId()=" + getId() + ", getName()=" + getName() + ", getSurvey()=" + getSurvey() + "]";
    }

}

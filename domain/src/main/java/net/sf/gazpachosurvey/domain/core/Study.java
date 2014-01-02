package net.sf.gazpachosurvey.domain.core;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.types.SurveyInstanceType;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class Study extends AbstractAuditable {

    private static final long serialVersionUID = -5917291757324504802L;

    private String name;

    @Enumerated(EnumType.STRING)
    private SurveyInstanceType type;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime startDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime expirationDate;

    @OneToMany(mappedBy = "study", fetch = FetchType.LAZY)
    private Set<Questionnair> questionnairs;

    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(name = "surveyinstance_participant", joinColumns = { @JoinColumn(name = "surveyinstance_id",
    // referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "participant_id", referencedColumnName
    // = "id") })
    // private Set<Participant> participants;

    public Study() {
        super();
    }

    /*
     * public void addParticipant(Participant participant) { Assert.notNull(participant,
     * "Participant must be not null"); participant.getSurveyInstances().add(this); getParticipants().add(participant);
     * }
     */

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Set<Questionnair> getQuestionnairs() {
        return questionnairs;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public SurveyInstanceType getType() {
        return type;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestionnairs(Set<Questionnair> questionnairs) {
        this.questionnairs = questionnairs;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(SurveyInstanceType type) {
        this.type = type;
    }

}

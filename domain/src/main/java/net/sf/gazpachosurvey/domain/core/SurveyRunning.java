package net.sf.gazpachosurvey.domain.core;

import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import net.sf.gazpachosurvey.domain.user.User;

import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import javax.persistence.*;

@Entity
//public class SurveyRunning extends AbstractAuditable<User, Integer> {
    // public class SurveyRunning implements Auditable<User, Integer> {

//public class SurveyRunning implements Auditable<User, Integer> { // SI
    public class SurveyRunning extends AbstractAuditable<Integer, User> {    

    //@AttributeOverride(column = @Column, name = "id")

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
*/
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @ManyToMany
    private Set<Participant> participants;

    private String name;

    public SurveyRunning() {
        super();
    }

/*    public DateTime getCreatedDate() {

        return null == createdDate ? null : new DateTime(createdDate);
    }

    public void setCreatedDate(final DateTime createdDate) {

        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    public DateTime getLastModifiedDate() {

        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null
                : lastModifiedDate.toDate();
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
*/
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Set<Participant> getParticipants() {
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

    @Override
    public String toString() {
        return "SurveyRunning [getId()=" + getId() + ", getName()=" + getName()
                + ", getSurvey()=" + getSurvey() + "]";
    }

}

package net.sf.gazpachosurvey.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;


@Entity
public class Participant extends AbstractPersistable<Integer> {
    
    private static final long serialVersionUID = 6716148852807992302L;

    private String firstname;
    
    private String lastname;
    
    private String email;

    @ManyToMany(mappedBy = "participants")
    private Set<SurveyRunning> surveyRunnings;

    public Participant() {
        super();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<SurveyRunning> getSurveyRunnings() {
        if (surveyRunnings == null){
            this.surveyRunnings = new HashSet<>();
        }
            
        return surveyRunnings;
    }

    public void setSurveyRunnings(Set<SurveyRunning> surveyRunning) {
        this.surveyRunnings = surveyRunning;
    }

}

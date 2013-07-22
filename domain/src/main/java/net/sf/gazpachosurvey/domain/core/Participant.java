package net.sf.gazpachosurvey.domain.core;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class Participant extends AbstractPersistable<Integer> {
    private String firstname;
    private String lastname;
    private String email;
    private String language;

    private Set<SurveyRunning> surveyRunning;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @ManyToMany(mappedBy = "participants")
    public Set<SurveyRunning> getSurveyRunning() {
        return surveyRunning;
    }

    public void setSurveyRunning(Set<SurveyRunning> surveyRunning) {
        this.surveyRunning = surveyRunning;
    }

}

package net.sf.gazpachosurvey.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.types.Gender;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Participant extends AbstractAuditable{

    private static final long serialVersionUID = 6716148852807992302L;

    private String firstname;

    private String lastname;

    private String email;
    
    private Language preferedLanguage;

    private Gender gender;

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
        if (surveyRunnings == null) {
            surveyRunnings = new HashSet<>();
        }

        return surveyRunnings;
    }

    public void setSurveyRunnings(Set<SurveyRunning> surveyRunning) {
        surveyRunnings = surveyRunning;
    }

    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    public void setPreferedLanguage(Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
}

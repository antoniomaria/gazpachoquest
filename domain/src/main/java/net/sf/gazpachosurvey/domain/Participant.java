package net.sf.gazpachosurvey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class Participant extends AbstractPersistable<Integer> {
    private String firstname;
    private String lastname;
    private String email;
    private String language;

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

    @Column(name = "e_mail")
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

}

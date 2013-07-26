package net.sf.gazpachosurvey.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.sf.gazpachosurvey.domain.support.AuditableEntity;

@Entity
public class User extends AuditableEntity<Integer> {
    
    private String firstname;
    
    private String lastname;
    
    private String email;

    public User() {
        super();
    }

    @Column(nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(nullable = false)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

}

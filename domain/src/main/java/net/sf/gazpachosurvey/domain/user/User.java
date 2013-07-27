package net.sf.gazpachosurvey.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.sf.gazpachosurvey.domain.support.AuditableEntity;

@Entity
public class User extends AuditableEntity<Integer> {
    
    private String firstName;
    
    private String lastName;
    
    private String email;

    public User() {
        super();
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

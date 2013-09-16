package net.sf.gazpachosurvey.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 6513048922124388025L;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    public User() {
        super();
    }

    public void setId(Integer id) {
        super.setId(id);
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

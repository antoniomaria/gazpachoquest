package net.sf.gazpachosurvey.domain.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.sf.gazpachosurvey.domain.support.AbstractPerson;

@Entity
@Table(name = "users")
public class User extends AbstractPerson {

    private static final long serialVersionUID = 6513048922124388025L;
    
    // TODO constraints have been removed until session customizer works
    private String firstName;

    private String lastName;

    //@Column(nullable = false, unique = true)
    private String email;

    public User() {
        super();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

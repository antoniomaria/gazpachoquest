package net.sf.gazpachoquest.domain.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.gazpachoquest.domain.support.AbstractPerson;

@Entity
@Table(name = "users")
public class User extends AbstractPerson {

    private static final long serialVersionUID = 6513048922124388025L;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Transient
    private Set<String> roles;

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

    @Override
    @Transient
    public String getName() {
        return email;
    }

    @Override
    public Set<String> getRoles() {
        if (roles == null) {
            roles = new HashSet<String>();
        }
        return roles;
    }

}

package net.sf.gazpachoquest.domain.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;
import net.sf.gazpachoquest.domain.support.User;

@Entity
public class Group extends AbstractAuditable {

    private static final long serialVersionUID = 2209952243152855595L;

    private String name;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<User> users;

    public Group() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}

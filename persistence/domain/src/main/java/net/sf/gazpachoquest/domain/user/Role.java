package net.sf.gazpachoquest.domain.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;

@SuppressWarnings("serial")
@Entity
public class Role extends AbstractPersistable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private final Set<User> users = new HashSet<User>();

    public Role() {
        super();
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void assignUser(User user) {
        users.add(user);
        user.addRole(this);
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Role build() {
            Role role = new Role();
            role.setId(id);
            role.name = name;
            role.description = description;
            return role;
        }
    }
}

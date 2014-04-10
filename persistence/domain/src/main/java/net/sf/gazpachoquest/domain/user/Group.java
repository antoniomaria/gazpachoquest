package net.sf.gazpachoquest.domain.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;

@Entity
@Table(name = "groups")
public class Group extends AbstractAuditable {

    private static final long serialVersionUID = 2209952243152855595L;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "group_role", joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Set<Role> roles;

    public Group() {
        super();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void assignUser(User user) {
        getUsers().add(user);
        user.getGroups().add(this);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String description;
        private Set<User> users;

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

        public Builder users(Set<User> users) {
            this.users = users;
            return this;
        }

        public Group build() {
            Group group = new Group();
            group.setId(id);
            group.name = name;
            group.description = description;
            group.users = users;
            return group;
        }
    }
}

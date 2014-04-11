package net.sf.gazpachoquest.domain.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;

@Entity
public class Permission extends AbstractPersistable {

    private static final long serialVersionUID = 6599066653542691509L;

    private String name;

    public Permission() {
        super();
    }

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Set<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Permission build() {
            Permission permission = new Permission();
            permission.name = name;
            permission.setId(id);
            return permission;
        }
    }
}

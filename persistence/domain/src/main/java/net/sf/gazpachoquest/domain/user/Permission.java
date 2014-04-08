package net.sf.gazpachoquest.domain.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;

@Entity
public class Permission extends AbstractPersistable {

    private static final long serialVersionUID = 6599066653542691509L;

    private String name;

    public Permission() {
        super();
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private Role role;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Permission build() {
            Permission permission = new Permission();
            permission.name = name;
            permission.role = role;
            permission.setId(id);
            return permission;
        }
    }
}

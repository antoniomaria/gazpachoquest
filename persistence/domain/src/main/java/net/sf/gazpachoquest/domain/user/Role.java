package net.sf.gazpachoquest.domain.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.types.RoleScope;

@Entity
public class Role extends AbstractPersistable {

    private static final long serialVersionUID = 2224168321199809660L;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Group> groups;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleScope scope;

    public Role() {
        super();
    }

    public Set<Group> getGroups() {
    	if (groups == null){
    		this.groups = new HashSet<Group>();
    	}
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<User> getUsers() {
    	if (users == null){
    		this.users = new HashSet<User>();
    	}
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

    public Set<Permission> getPermissions() {
    	if (permissions == null){
    		this.permissions = new HashSet<Permission>();
    	}
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleScope getScope() {
		return scope;
	}

	public void setScope(RoleScope scope) {
		this.scope = scope;
	}
	
	public void assignPermission(Permission permission){
		getPermissions().add(permission);
		permission.getRoles().add(this);
	}

	public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String description;
        private RoleScope scope;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder scope(RoleScope scope) {
            this.scope = scope;
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
            role.scope = scope;
            role.name = name;
            role.description = description;
            return role;
        }
    }
}

package net.sf.gazpachoquest.domain.user;

import java.util.Set;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;

// @Entity
// @Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn(name = "subject_type", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Subject extends AbstractAuditable {

    private static final long serialVersionUID = -8086977287021294986L;

    // @ManyToMany
    // @JoinTable(name = "subject_role", joinColumns = { @JoinColumn(name = "subject_id", referencedColumnName = "id")
    // }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Set<Role> roles;

    public Subject() {
        super();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

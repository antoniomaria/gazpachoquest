package net.sf.gazpachoquest.domain.permission;

import javax.persistence.Entity;

import net.sf.gazpachoquest.domain.support.AbstractPermission;
import net.sf.gazpachoquest.domain.user.Directory;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.Perm;

@Entity
public class DirectoryPermission extends AbstractPermission<Directory> {

    private static final long serialVersionUID = 8330893603469347818L;

    public DirectoryPermission() {
        super();
    }

    public DirectoryPermission(Integer id, User user, Role role, Integer mask, Directory target) {
        super(id, user, role, mask, target);
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder {
        private Integer id;
        private User user;
        private Role role;
        private int mask;
        private Directory target;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder mask(int mask) {
            this.mask = mask;
            return this;
        }

        public Builder target(Directory target) {
            this.target = target;
            return this;
        }

        public Builder addPerm(Perm perm) {
            if ((mask & perm.getMask()) != perm.getMask()) {
                mask += perm.getMask();
            }
            return this;

        }

        public DirectoryPermission build() {
            return new DirectoryPermission(id, user, role, mask, target);
        }
    }

}

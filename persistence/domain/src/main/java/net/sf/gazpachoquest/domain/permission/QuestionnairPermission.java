package net.sf.gazpachoquest.domain.permission;

import javax.persistence.Entity;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.Perm;

@Entity
public class QuestionnairPermission extends AbstractPermission<Questionnair> {

    private static final long serialVersionUID = 8330893603469347818L;

    public QuestionnairPermission() {
        super();
    }

    public QuestionnairPermission(Integer id, User user, Role role, Integer mask, Questionnair target) {
        super(id, user, role, mask, target);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private User user;
        private Role role;
        private int mask;
        private Questionnair target;

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

        public Builder target(Questionnair target) {
            this.target = target;
            return this;
        }

        public Builder addPerm(Perm perm) {
            if ((mask & perm.getMask()) != perm.getMask()) {
                mask += perm.getMask();
            }
            return this;

        }

        public QuestionnairPermission build() {
            return new QuestionnairPermission(id, user, role, mask, target);
        }
    }

}

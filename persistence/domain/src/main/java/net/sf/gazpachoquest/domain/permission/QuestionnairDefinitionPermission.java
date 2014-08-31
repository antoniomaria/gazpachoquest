package net.sf.gazpachoquest.domain.permission;

import javax.persistence.Entity;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.Perm;

@Entity
public class QuestionnairDefinitionPermission extends AbstractPermission<QuestionnairDefinition> {

    private static final long serialVersionUID = 8330893603469347818L;

    public QuestionnairDefinitionPermission() {
        super();
    }

    public QuestionnairDefinitionPermission(User user, Role role, Integer mask, QuestionnairDefinition target) {
        super(user, role, mask, target);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private User user;
        private Role role;
        private int mask;
        private QuestionnairDefinition target;

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

        public Builder target(QuestionnairDefinition target) {
            this.target = target;
            return this;
        }

        public Builder addPerm(Perm perm) {
            if ((mask & perm.getMask()) != perm.getMask()) {
                mask += perm.getMask();
            }
            return this;

        }

        public QuestionnairDefinitionPermission build() {
            return new QuestionnairDefinitionPermission(user, role, mask, target);
        }
    }

}

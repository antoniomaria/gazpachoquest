package net.sf.gazpachoquest.domain.support;

import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;

public interface Permission<T extends Persistable> extends Persistable {
    User getUser();

    Integer getMask();

    Role getRole();

    public T getTarget();
}

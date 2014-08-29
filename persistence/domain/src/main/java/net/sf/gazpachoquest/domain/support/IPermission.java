package net.sf.gazpachoquest.domain.support;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.User;

public interface IPermission<T extends Persistable> extends Persistable {
    User getUser();

    Integer getMask();

    Group getGroup();

    public T getTarget();
}

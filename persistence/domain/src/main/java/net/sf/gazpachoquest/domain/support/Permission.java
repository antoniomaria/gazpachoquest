package net.sf.gazpachoquest.domain.support;

import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;

/**
 * @assoc - issueTo 1 net.sf.gazpachoquest.domain.user.User
 * @assoc - issueTo 1 net.sf.gazpachoquest.domain.user.Role
 * @assoc - grantAccess 1 Securizable
 * 
 */
public interface Permission<T extends Persistable> extends Persistable {
    User getUser();

    Integer getMask();

    Role getRole();

    public T getTarget();

    String getLiteral();
}

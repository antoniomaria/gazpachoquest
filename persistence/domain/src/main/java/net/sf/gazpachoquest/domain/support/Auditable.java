package net.sf.gazpachoquest.domain.support;

import net.sf.gazpachoquest.domain.user.User;

import org.joda.time.DateTime;

public interface Auditable extends Persistable {
    User getCreatedBy();

    User getLastModifiedBy();

    DateTime getCreatedDate();

    DateTime getLastModifiedDate();
}

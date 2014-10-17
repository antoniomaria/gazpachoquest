package net.sf.gazpachoquest.domain.support;

import net.sf.gazpachoquest.domain.user.User;

import org.joda.time.LocalDateTime;

public interface Auditable extends Persistable {
    User getCreatedBy();

    User getLastModifiedBy();

    LocalDateTime getCreatedDate();

    LocalDateTime getLastModifiedDate();
}

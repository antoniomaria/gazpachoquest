package net.sf.gazpachoquest.domain.support;

import java.time.LocalDateTime;

import net.sf.gazpachoquest.domain.user.User;


public interface Auditable extends Persistable {
    User getCreatedBy();

    User getLastModifiedBy();

    LocalDateTime getCreatedDate();

    LocalDateTime getLastModifiedDate();
}

package net.sf.gazpachoquest.domain.support;

import java.io.Serializable;

public interface Persistable extends Serializable {

    Integer getId();

    boolean isNew();
}

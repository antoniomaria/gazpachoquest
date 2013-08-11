package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

public interface Persistable<PK extends Serializable> extends Serializable{

    PK getId();

    boolean isNew();
}

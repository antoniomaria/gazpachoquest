package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

public interface Persistable<ID extends Serializable> extends Serializable{

    ID getId();

    boolean isNew();
}

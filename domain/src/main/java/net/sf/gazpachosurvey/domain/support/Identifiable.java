package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

public interface Identifiable<PK extends Serializable> {

    PK getId();

    boolean isNew();
}

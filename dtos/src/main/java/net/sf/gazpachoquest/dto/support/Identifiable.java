package net.sf.gazpachoquest.dto.support;

import java.io.Serializable;

public interface Identifiable extends Serializable {

    Integer getId();

    boolean isNew();

}

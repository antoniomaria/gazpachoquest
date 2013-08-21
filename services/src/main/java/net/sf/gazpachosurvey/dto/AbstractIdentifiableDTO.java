package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

public class AbstractIdentifiableDTO<ID extends Serializable> implements Identifiable<ID> {

    private static final long serialVersionUID = 2830103041683278252L;

    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
    
    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

}

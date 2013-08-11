package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

import net.sf.gazpachosurvey.domain.support.Persistable;

public class AbstractIdentifiableDTO <ID extends Serializable> implements Identifiable<ID>{

    private static final long serialVersionUID = 2830103041683278252L;

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }
    
  
}

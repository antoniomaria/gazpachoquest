package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

import net.sf.gazpachosurvey.domain.support.Identifiable;

public class AbstractSerializableDTO <PK extends Serializable> implements Identifiable<PK>{

    private static final long serialVersionUID = 3903947392347573567L;

    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }
    
    @Override
    public boolean isNew() {
        return null == getId();
    }
}

package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

public class AbstractSerializableDTO <PK extends Serializable> implements Serializable{

    private static final long serialVersionUID = -5351108281646989742L;

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
}

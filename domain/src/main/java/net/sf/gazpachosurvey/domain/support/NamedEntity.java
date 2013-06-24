package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity<PK extends Serializable> extends
        AuditableEntity<PK> {

    private String name;

    public NamedEntity() {
        super();
    }

    public NamedEntity(String name) {
        super();
        this.name = name;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

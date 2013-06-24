package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractPersistable<PK extends Serializable> implements
        Identifiable<PK> {

    private PK id;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * @return the primary key
     */
    public PK getId() {
        return id;
    }

    /**
     * Sets the primary key
     */

    @Override
    public void setId(PK id) {
        this.id = id;
    }

    /**
     * Helper method to know whether the primary key is set or not.
     * 
     * @return true if the primary key is set, false otherwise
     */
    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractPersistable other = (AbstractPersistable) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Entity type %s with id: %s", this.getClass()
                .getName(), getId());
    }
}

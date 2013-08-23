package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

import net.sf.gazpachosurvey.domain.support.Persistable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public int hashCode() {
        if (!isNew()) {
            return (new HashCodeBuilder()).append(getId()).toHashCode();
        } else {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Identifiable<?>) {
            final Identifiable<?> other = (Identifiable<?>) obj;
            if (!isNew()) {
                return (new EqualsBuilder())
                        .append(this.getId(), other.getId()).isEquals();
            } else {
                return EqualsBuilder.reflectionEquals(this, obj);
            }
        } else {
            return false;
        }
    }

}

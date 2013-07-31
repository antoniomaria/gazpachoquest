package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class AbstractPersistable<PK extends Serializable> implements
        Identifiable<PK> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default")
    @SequenceGenerator(name="default", sequenceName="id_generator_sequence", allocationSize = 1, initialValue = 1)
    private PK id;

    @Override
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public boolean isNew() {
        return null == getId();
    }

    @Override
    public String toString() {

        return String.format("Entity of type %s with id: %s", this.getClass()
                .getName(), getId());
    }

    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractPersistable<?> that = (AbstractPersistable<?>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

}

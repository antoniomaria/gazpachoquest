package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AuditableEntity<PK extends Serializable> extends
        AbstractPersistable<PK> {

    private String createdBy;

    private Date creationDate;

    private String updatedBy;

    private Date updateDate;

    public String getCreatedBy() {
        return createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}

package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.sf.gazpachosurvey.domain.user.User;

@MappedSuperclass
public abstract class AuditableEntity<PK extends Serializable> extends
        AbstractPersistable<PK> {

    private User createdBy;

    private Date creationDate;

    private User updatedBy;

    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    public User getCreatedBy() {
        return createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public User getUpdatedBy() {
        return updatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}

package net.sf.gazpachosurvey.domain.support;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import net.sf.gazpachosurvey.domain.user.User;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class AbstractAuditable<PK extends Serializable> extends
        AbstractPersistable<PK> {
    
    @ManyToOne(targetEntity = User.class)
    @CreatedBy
    private User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @ManyToOne(targetEntity = User.class)
    @LastModifiedBy
    private User lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;

    public User getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(final User createdBy) {

        this.createdBy = createdBy;
    }

    public DateTime getCreatedDate() {

        return null == createdDate ? null : new DateTime(createdDate);
    }

    public void setCreatedDate(final DateTime createdDate) {

        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    public User getLastModifiedBy() {

        return lastModifiedBy;
    }

    public void setLastModifiedBy(final User lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {

        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null
                : lastModifiedDate.toDate();
    }
}

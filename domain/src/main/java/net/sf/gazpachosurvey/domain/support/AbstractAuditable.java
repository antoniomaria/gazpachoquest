package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.sf.gazpachosurvey.domain.user.User;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class AbstractAuditable<PK extends Serializable> extends
        AbstractPersistable<PK> {
    
    private static final long serialVersionUID = 6507308518779364972L;

    @ManyToOne(targetEntity = User.class)
    @CreatedBy
    private User createdBy;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    @CreatedDate
    private DateTime createdDate;

    @ManyToOne(targetEntity = User.class)
    @LastModifiedBy
    private User lastModifiedBy;


    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    @LastModifiedDate
    private DateTime lastModifiedDate;

    public User getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(final User createdBy) {

        this.createdBy = createdBy;
    }

    public User getLastModifiedBy() {

        return lastModifiedBy;
    }

    public void setLastModifiedBy(final User lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}

package net.sf.gazpachosurvey.domain.support;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import net.sf.gazpachosurvey.domain.user.User;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class AbstractAuditable extends AbstractPersistable {

    private static final long serialVersionUID = 6507308518779364972L;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User createdBy;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    @CreatedDate
    private DateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User lastModifiedBy;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    @LastModifiedDate
    private DateTime lastModifiedDate;

    protected AbstractAuditable() {
        super();
    }

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

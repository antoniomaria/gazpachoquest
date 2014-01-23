package net.sf.gazpachosurvey.dto.support;

import net.sf.gazpachosurvey.dto.UserDTO;

import org.joda.time.DateTime;

public abstract class AbstractAuditableDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -6660330858580421664L;

    private UserDTO createdBy;

    private DateTime createdDate;

    private UserDTO lastModifiedBy;

    private DateTime lastModifiedDate;

    protected AbstractAuditableDTO() {
        super();
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public UserDTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setCreatedBy(final UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(final DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(final UserDTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}

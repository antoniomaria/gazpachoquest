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

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserDTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UserDTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}

/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto.support;

import javax.xml.bind.annotation.XmlTransient;

import net.sf.gazpachoquest.dto.UserDTO;

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

    @XmlTransient
    public UserDTO getCreatedBy() {
        return createdBy;
    }

    @XmlTransient
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @XmlTransient
    public UserDTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    @XmlTransient
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

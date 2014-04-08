/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.dto.ManagerDTO;

import org.joda.time.DateTime;

public abstract class AbstractAuditableDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -6660330858580421664L;

    private ManagerDTO createdBy;

    private DateTime createdDate;

    private ManagerDTO lastModifiedBy;

    private DateTime lastModifiedDate;

    protected AbstractAuditableDTO() {
        super();
    }

    public ManagerDTO getCreatedBy() {
        return createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public ManagerDTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setCreatedBy(final ManagerDTO createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(final DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(final ManagerDTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}

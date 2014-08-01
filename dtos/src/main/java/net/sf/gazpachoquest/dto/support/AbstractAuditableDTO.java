/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.dto.AuditorDTO;

import org.joda.time.DateTime;

public abstract class AbstractAuditableDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -6660330858580421664L;

    private AuditorDTO createdBy;

    private DateTime createdDate;

    private AuditorDTO lastModifiedBy;

    private DateTime lastModifiedDate;

    protected AbstractAuditableDTO() {
        super();
    }

    public AuditorDTO getCreatedBy() {
        return createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public AuditorDTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setCreatedBy(final AuditorDTO createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(final DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(final AuditorDTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}

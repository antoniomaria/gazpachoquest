/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.support;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.jpa.converter.DateTimeConverter;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class AbstractAuditable extends AbstractPersistable {

    private static final long serialVersionUID = 6507308518779364972L;

    @ManyToOne(optional = false)
    @CreatedBy
    private User createdBy;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    @CreatedDate
    private DateTime createdDate;

    @ManyToOne(optional = true)
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

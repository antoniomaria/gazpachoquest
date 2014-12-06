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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractIdentifiableDTO implements Identifiable {

    private static final long serialVersionUID = 2830103041683278252L;

    private Integer id;

    private Integer version;

    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Current object version. Used to prevent updated conflicts in a concurrent
     * environment using a optimistic locking strategy.
     * 
     * @see <a
     *      href="http://en.wikibooks.org/wiki/Java_Persistence/Locking">Optimistic
     *      Version Locking</a>
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        if (!isNew()) {
            return new HashCodeBuilder().append(getId()).toHashCode();
        } else {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Identifiable) {
            final Identifiable other = (Identifiable) obj;
            if (!isNew()) {
                return new EqualsBuilder().append(getId(), other.getId()).isEquals();
            } else {
                return EqualsBuilder.reflectionEquals(this, obj);
            }
        } else {
            return false;
        }
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return null == getId();
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

}

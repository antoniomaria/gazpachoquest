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
package net.sf.gazpachoquest.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable;
import net.sf.gazpachoquest.jpa.converter.DateTimeConverter;
import net.sf.gazpachoquest.jpa.converter.ResearchAccessTypeConverter;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.joda.time.DateTime;

@Entity
public class Research extends AbstractSecurizable<ResearchPermission> {

    private static final long serialVersionUID = -5917291757324504802L;

    private String name;

    @Convert(converter = ResearchAccessTypeConverter.class)
    private ResearchAccessType type;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime startDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime expirationDate;

    @OneToMany(mappedBy = "research", fetch = FetchType.LAZY)
    private final Set<Questionnair> questionnairs = new HashSet<Questionnair>();

    public Research() {
        super();
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Set<Questionnair> getQuestionnairs() {
        return questionnairs;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public ResearchAccessType getType() {
        return type;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(ResearchAccessType type) {
        this.type = type;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private ResearchAccessType type;
        private DateTime startDate;
        private DateTime expirationDate;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(ResearchAccessType type) {
            this.type = type;
            return this;
        }

        public Builder startDate(DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Research build() {
            Research research = new Research();
            research.setId(id);
            research.name = name;
            research.type = type;
            research.startDate = startDate;
            research.expirationDate = expirationDate;
            return research;
        }
    }
}

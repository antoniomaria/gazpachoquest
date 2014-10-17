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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable;
import net.sf.gazpachoquest.jpa.converter.EntityStatusConverter;
import net.sf.gazpachoquest.jpa.converter.LocalDateTimeConverter;
import net.sf.gazpachoquest.jpa.converter.ResearchAccessTypeConverter;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.joda.time.LocalDateTime;

@Entity
public class Research extends AbstractSecurizable<ResearchPermission> {

    private static final long serialVersionUID = -5917291757324504802L;

    @Column(nullable = false)
    @Convert(converter = EntityStatusConverter.class)
    private EntityStatus status;

    private String name;

    @Convert(converter = ResearchAccessTypeConverter.class)
    private ResearchAccessType type;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime expirationDate;

    @OneToMany(mappedBy = "research", fetch = FetchType.LAZY)
    private final Set<Questionnaire> questionnaires = new HashSet<Questionnaire>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionnaireDefinition questionnaireDefinition;

    public Research() {
        super();
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public ResearchAccessType getType() {
        return type;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(ResearchAccessType type) {
        this.type = type;
    }

    public Set<Questionnaire> getQuestionnaires() {
        return Collections.unmodifiableSet(questionnaires);
    }

    public QuestionnaireDefinition getQuestionnaireDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private ResearchAccessType type;
        private LocalDateTime startDate;
        private LocalDateTime expirationDate;
        private EntityStatus status;

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

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expirationDate(LocalDateTime expirationDate) {
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
            research.status = status;
            return research;
        }
    }
}

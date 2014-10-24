/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

import net.sf.gazpachoquest.domain.permission.QuestionnairePermission;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.jpa.converter.EntityStatusConverter;
import net.sf.gazpachoquest.jpa.converter.LocalDateTimeConverter;
import net.sf.gazpachoquest.types.EntityStatus;

import org.joda.time.LocalDateTime;
import org.springframework.util.Assert;

@Entity
public class Questionnaire extends AbstractSecurizable<QuestionnairePermission> {

    private static final long serialVersionUID = -5466079670655149390L;

    @Column(nullable = false)
    @Convert(converter = EntityStatusConverter.class)
    private EntityStatus status;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "navigation_order")
    private final List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();

    @Column(columnDefinition = "timestamp")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime submitDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Research research;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionnaireDefinition questionnaireDefinition;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User respondent;

    @Basic
    private Integer answersId;

    public Questionnaire() {
        super();
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        Assert.notNull(breadcrumb);
        breadcrumb.setQuestionnaire(this);
        breadcrumbs.add(breadcrumb);
    }

    public void setBreadcrumb(int pos, Breadcrumb breadcrumb) {
        breadcrumbs.set(pos, breadcrumb);
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    public LocalDateTime getSubmitDate() {
        return submitDate;
    }

    public Research getResearch() {
        return research;
    }

    public void setSubmitDate(final LocalDateTime submitDate) {
        this.submitDate = submitDate;
    }

    public void setResearch(final Research research) {
        this.research = research;
    }

    public QuestionnaireDefinition getQuestionnaireDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
    }

    public User getRespondent() {
        return respondent;
    }

    public void setRespondent(User respondent) {
        this.respondent = respondent;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Integer getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Integer answersId) {
        this.answersId = answersId;
    }

    @Transient
    public boolean isDraft() {
        return status == null ? true : status == EntityStatus.DRAFT;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private LocalDateTime submitDate;
        private Research research;
        private QuestionnaireDefinition questionnaireDefinition;
        private User respondent;
        private Integer answersId;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder submitDate(LocalDateTime submitDate) {
            this.submitDate = submitDate;
            return this;
        }

        public Builder answersId(Integer answersId) {
            this.answersId = answersId;
            return this;
        }

        public Builder research(Research research) {
            this.research = research;
            return this;
        }

        public Builder questionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
            return this;
        }

        public Builder respondent(User respondent) {
            this.respondent = respondent;
            return this;
        }

        public Questionnaire build() {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(id);
            questionnaire.status = status;
            questionnaire.submitDate = submitDate;
            questionnaire.research = research;
            questionnaire.questionnaireDefinition = questionnaireDefinition;
            questionnaire.respondent = respondent;
            questionnaire.answersId = answersId;
            return questionnaire;
        }
    }
}

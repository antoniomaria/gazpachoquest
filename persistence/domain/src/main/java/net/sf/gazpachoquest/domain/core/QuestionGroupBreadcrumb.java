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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
@DiscriminatorValue("G")
public class QuestionGroupBreadcrumb extends Breadcrumb {

    private static final long serialVersionUID = -1490244249723723725L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionGroup questionGroup;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "order_in_breadcrumb_group")
    private final List<QuestionBreadcrumb> breadcrumbs = new ArrayList<QuestionBreadcrumb>();

    public QuestionGroupBreadcrumb() {
        super();
    }

    public QuestionGroup getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public List<QuestionBreadcrumb> getBreadcrumbs() {
        return Collections.unmodifiableList(breadcrumbs);
    }

    public void addBreadcrumb(QuestionBreadcrumb breadcrumb) {
        breadcrumbs.add(breadcrumb);
    }
    
    public Boolean hasBreadcrumbs(){
        return !breadcrumbs.isEmpty();
    }

    public static QuestionGroupBreadcrumb.Builder with() {
        return new QuestionGroupBreadcrumb.Builder();
    }

    public static class Builder {
        private QuestionGroup questionGroup;

        private Questionnair questionnair;

        private Boolean last;

        public Builder last(Boolean last) {
            this.last = last;
            return this;
        }

        public Builder questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public Builder questionGroup(QuestionGroup questionGroup) {
            this.questionGroup = questionGroup;
            return this;
        }

        public QuestionGroupBreadcrumb build() {
            QuestionGroupBreadcrumb questionGroupBreadcrumb = new QuestionGroupBreadcrumb();
            questionGroupBreadcrumb.setLast(last);
            questionGroupBreadcrumb.questionGroup = questionGroup;
            questionGroupBreadcrumb.questionnair = questionnair;
            return questionGroupBreadcrumb;
        }
    }
}

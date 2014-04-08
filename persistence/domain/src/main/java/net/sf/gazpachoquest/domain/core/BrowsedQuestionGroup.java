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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("G")
public class BrowsedQuestionGroup extends BrowsedElement {

    private static final long serialVersionUID = -1490244249723723725L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionGroup questionGroup;

    public BrowsedQuestionGroup() {
        super();
    }

    public QuestionGroup getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public static BrowsedQuestionGroup.Builder with() {
        return new BrowsedQuestionGroup.Builder();
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

        public BrowsedQuestionGroup build() {
            BrowsedQuestionGroup browsedQuestionGroup = new BrowsedQuestionGroup();
            browsedQuestionGroup.setLast(last);
            browsedQuestionGroup.questionGroup = questionGroup;
            browsedQuestionGroup.questionnair = questionnair;
            return browsedQuestionGroup;
        }
    }
}

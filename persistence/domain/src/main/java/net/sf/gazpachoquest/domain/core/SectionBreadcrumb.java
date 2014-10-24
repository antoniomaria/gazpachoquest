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

import org.springframework.util.Assert;

import net.sf.gazpachoquest.types.RenderingMode;

@Entity
@DiscriminatorValue("S")
public class SectionBreadcrumb extends Breadcrumb {

    private static final long serialVersionUID = -1490244249723723725L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_in_section_breadcrumb")
    private final List<QuestionBreadcrumb> breadcrumbs = new ArrayList<QuestionBreadcrumb>();

    private Integer questionsDisplayedCount;
    
    public SectionBreadcrumb() {
        super();
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<QuestionBreadcrumb> getBreadcrumbs() {
        return Collections.unmodifiableList(breadcrumbs);
    }

    public void addBreadcrumb(QuestionBreadcrumb breadcrumb) {
        breadcrumbs.add(breadcrumb);
        breadcrumb.setParent(this);
    }

    public Boolean hasBreadcrumbs() {
        return !breadcrumbs.isEmpty();
    }

    public Integer getQuestionsDisplayedCount() {
        return questionsDisplayedCount;
    }

    public void setQuestionsDisplayedCount(Integer questionsDisplayedCount) {
        this.questionsDisplayedCount = questionsDisplayedCount;
    }

    public Integer getQuestionsBreadcrumbCount(){
        return breadcrumbs.size();
    }
    public static SectionBreadcrumb.Builder with() {
        return new SectionBreadcrumb.Builder();
    }

    public static class Builder {
        private Integer id;

        private Section section;

        private Questionnaire questionnaire;

        private Boolean last;

        private RenderingMode renderingMode;
        
        private Integer questionsDisplayedCount;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder last(Boolean last) {
            this.last = last;
            return this;
        }

        public Builder questionsDisplayedCounter(Integer questionsDisplayedCount) {
            this.questionsDisplayedCount = questionsDisplayedCount;
            return this;
        }
        public Builder renderingMode(RenderingMode renderingMode) {
            Assert.notNull(renderingMode);
            this.renderingMode = renderingMode;
            return this;
        }

        public Builder questionnaire(Questionnaire questionnaire) {
            Assert.notNull(questionnaire);
            this.questionnaire = questionnaire;
            return this;
        }

        public Builder section(Section section) {
            Assert.notNull(section);
            this.section = section;
            return this;
        }

        public SectionBreadcrumb build() {
            SectionBreadcrumb sectionBreadcrumb = new SectionBreadcrumb();
            sectionBreadcrumb.setId(id);
            sectionBreadcrumb.setLast(last);
            sectionBreadcrumb.setRenderingMode(renderingMode);
            sectionBreadcrumb.section = section;
            sectionBreadcrumb.questionnaire = questionnaire;
            sectionBreadcrumb.questionsDisplayedCount = questionsDisplayedCount;
            return sectionBreadcrumb;
        }
    }
}

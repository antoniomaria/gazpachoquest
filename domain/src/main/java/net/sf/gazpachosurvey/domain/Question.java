package net.sf.gazpachosurvey.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class Question extends AbstractPersistable<Integer> {

    private Survey survey;

    private Question parent;

    private Set<Question> subquestions;

    private Set<ResponseOption> responseOptions;

    private int sortOrder;

    boolean isRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    public Set<Question> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(Set<Question> subquestions) {
        this.subquestions = subquestions;
    }

    @ManyToOne
    public Question getParent() {
        return parent;
    }

    public void setParent(Question parent) {
        this.parent = parent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    public Set<ResponseOption> getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(Set<ResponseOption> responseOptions) {
        this.responseOptions = responseOptions;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

}

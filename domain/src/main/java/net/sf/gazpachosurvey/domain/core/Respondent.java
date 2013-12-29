package net.sf.gazpachosurvey.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import net.sf.gazpachosurvey.domain.support.AbstractPerson;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class Respondent extends AbstractPerson {

    private static final long serialVersionUID = -5466079670655149390L;

    public final static String USER_NAME = "respondent";

    public final static String ROLE = USER_NAME;

    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyInstance surveyInstance;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime submitDate;

    @Transient
    private Set<String> roles;

    @OneToMany(mappedBy = "respondent", fetch = FetchType.LAZY)
    private Set<BrowsedElement> browsedElements;

    public Respondent() {
        super();
    }

    public SurveyInstance getSurveyInstance() {
        return surveyInstance;
    }

    public void setSurveyInstance(SurveyInstance surveyInstance) {
        this.surveyInstance = surveyInstance;
    }

    public DateTime getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(DateTime submitDate) {
        this.submitDate = submitDate;
    }

    public Set<BrowsedElement> getBrowsedElements() {
        return browsedElements;
    }

    public void setBrowsedElements(Set<BrowsedElement> browsedElements) {
        this.browsedElements = browsedElements;
    }

    @Override
    @Transient
    public String getName() {
        return USER_NAME;
    }

    @Override
    @Transient
    public Set<String> getRoles() {
        if (roles == null) {
            roles = new HashSet<String>();
            roles.add(ROLE);
        }
        return roles;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private SurveyInstance surveyInstance;
        private DateTime submitDate;
        private Set<BrowsedElement> browsedElements;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder surveyInstance(SurveyInstance surveyInstance) {
            this.surveyInstance = surveyInstance;
            return this;
        }

        public Builder submitDate(DateTime submitDate) {
            this.submitDate = submitDate;
            return this;
        }

        public Builder browsedElements(Set<BrowsedElement> browsedElements) {
            this.browsedElements = browsedElements;
            return this;
        }

        public Respondent build() {
            Respondent respondent = new Respondent();
            respondent.surveyInstance = surveyInstance;
            respondent.submitDate = submitDate;
            respondent.browsedElements = browsedElements;
            respondent.setId(id);
            return respondent;
        }
    }
}

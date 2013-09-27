package net.sf.gazpachosurvey.domain.core;

import java.util.Date;

import net.sf.gazpachosurvey.domain.support.Persistable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

public class Respondent implements Persistable {

    private static final long serialVersionUID = -5466079670655149390L;

    private Integer id;

    private Integer surveyId;

    private Integer surveyRunningId;

    private Date submitDate;

    private Date startDate;

    private String ipAddress;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public DateTime getSubmitDateTime() {
        return null == submitDate ? null : new DateTime(submitDate);
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public DateTime getStartDateTime() {
        return null == startDate ? null : new DateTime(startDate);
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

    public Integer getSurveyRunningId() {
        return surveyRunningId;
    }

    public void setSurveyRunningId(Integer surveyRunningId) {
        this.surveyRunningId = surveyRunningId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public int hashCode() {
        if (!isNew()) {
            return (new HashCodeBuilder()).append(getId()).toHashCode();
        } else {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persistable) {
            final Persistable other = (Persistable) obj;
            if (!isNew()) {
                return (new EqualsBuilder()).append(getId(), other.getId()).isEquals();
            } else {
                return EqualsBuilder.reflectionEquals(this, obj);
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    public static class Builder {
        private Integer id;
        private Integer surveyId;
        private Integer surveyRunningId;
        private Date submitDate;
        private Date startDate;
        private String ipAddress;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder surveyId(Integer surveyId) {
            this.surveyId = surveyId;
            return this;
        }

        public Builder surveyRunningId(Integer surveyRunningId) {
            this.surveyRunningId = surveyRunningId;
            return this;
        }

        public Builder submitDate(Date submitDate) {
            this.submitDate = submitDate;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Respondent build() {
            Respondent respondent = new Respondent();
            respondent.id = id;
            respondent.surveyId = surveyId;
            respondent.surveyRunningId = surveyRunningId;
            respondent.submitDate = submitDate;
            respondent.startDate = startDate;
            respondent.ipAddress = ipAddress;
            return respondent;
        }
    }
}

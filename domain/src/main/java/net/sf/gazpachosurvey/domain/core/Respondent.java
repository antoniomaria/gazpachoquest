package net.sf.gazpachosurvey.domain.core;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import net.sf.gazpachosurvey.domain.support.Persistable;

public class Respondent implements Persistable<Integer> {

    private static final long serialVersionUID = -5466079670655149390L;

    private Integer id;
    
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

    public DateTime getSubmitDate() {
        return null == submitDate ? null : new DateTime(submitDate);
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public DateTime getStartDate() {
        return null == startDate ? null : new DateTime(startDate);
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
        if (obj instanceof Persistable<?>) {
            final Persistable<?> other = (Persistable<?>) obj;
            if (!isNew()) {
                return (new EqualsBuilder())
                        .append(this.getId(), other.getId()).isEquals();
            } else {
                return EqualsBuilder.reflectionEquals(this, obj);
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass()
                .getName(), getId());
    }

    
}

package net.sf.gazpachosurvey.domain.core;

import java.util.Map;

import net.sf.gazpachosurvey.domain.support.Persistable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RespondentAnswers implements Persistable {
    private static final long serialVersionUID = -214686516454070394L;

    private Integer id;

    private Respondent respondent;
    
    private Map<String, Object> answers;
    
    public RespondentAnswers(){
        super();
    }
    
    public Respondent getRespondent() {
        return respondent;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }

    public Map<String, Object> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Object> answers) {
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return null == getId();
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
                return (new EqualsBuilder()).append(getId(), other.getId())
                        .isEquals();
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

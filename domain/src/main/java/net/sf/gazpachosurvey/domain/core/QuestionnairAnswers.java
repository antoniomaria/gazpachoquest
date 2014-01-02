package net.sf.gazpachosurvey.domain.core;

import java.util.Map;

import net.sf.gazpachosurvey.domain.support.Persistable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class QuestionnairAnswers implements Persistable {
    private static final long serialVersionUID = -214686516454070394L;

    private Integer id;

    private Questionnair questionnair;

    private Map<String, Object> answers;

    public QuestionnairAnswers() {
        super();
    }

    public Questionnair getQuestionnair() {
        return questionnair;
    }

    public void setQuestionnair(Questionnair questionnair) {
        this.questionnair = questionnair;
    }

    public Map<String, Object> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Object> answers) {
        this.answers = answers;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
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
}

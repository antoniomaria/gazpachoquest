package net.sf.gazpachosurvey.domain.core;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.types.StudyAccessType;
import net.sf.gazpachosurvey.domain.support.AbstractAuditable;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class Study extends AbstractAuditable {

    private static final long serialVersionUID = -5917291757324504802L;

    private String name;

    @Enumerated(EnumType.STRING)
    private StudyAccessType type;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime startDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime expirationDate;

    @OneToMany(mappedBy = "study", fetch = FetchType.LAZY)
    private Set<Questionnair> questionnairs;

    public Study() {
        super();
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Set<Questionnair> getQuestionnairs() {
        return questionnairs;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public StudyAccessType getType() {
        return type;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestionnairs(Set<Questionnair> questionnairs) {
        this.questionnairs = questionnairs;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(StudyAccessType type) {
        this.type = type;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private StudyAccessType type;
        private DateTime startDate;
        private DateTime expirationDate;
        private Set<Questionnair> questionnairs;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(StudyAccessType type) {
            this.type = type;
            return this;
        }

        public Builder startDate(DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder questionnairs(Set<Questionnair> questionnairs) {
            this.questionnairs = questionnairs;
            return this;
        }

        public Study build() {
            Study study = new Study();
            study.setId(id);
            study.name = name;
            study.type = type;
            study.startDate = startDate;
            study.expirationDate = expirationDate;
            study.questionnairs = questionnairs;
            return study;
        }
    }
}

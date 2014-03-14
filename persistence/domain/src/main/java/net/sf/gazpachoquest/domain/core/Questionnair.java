package net.sf.gazpachoquest.domain.core;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;
import net.sf.gazpachoquest.jpa.eclipselink.DateTimeConverter;
import net.sf.gazpachoquest.types.EntityStatus;

import org.joda.time.DateTime;

@Entity
public class Questionnair extends AbstractAuditable {

    private static final long serialVersionUID = -5466079670655149390L;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityStatus status;

    @OneToMany(mappedBy = "questionnair", fetch = FetchType.LAZY)
    private Set<BrowsedElement> browsedElements;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime submitDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionnairDefinition questionnairDefinition;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Participant participant;

    private Integer answersId;

    public Questionnair() {
        super();
    }

    public Set<BrowsedElement> getBrowsedElements() {
        return browsedElements;
    }

    public DateTime getSubmitDate() {
        return submitDate;
    }

    public Study getStudy() {
        return study;
    }

    public void setBrowsedElements(final Set<BrowsedElement> browsedElements) {
        this.browsedElements = browsedElements;
    }

    public void setSubmitDate(final DateTime submitDate) {
        this.submitDate = submitDate;
    }

    public void setStudy(final Study study) {
        this.study = study;
    }

    public QuestionnairDefinition getQuestionnairDefinition() {
        return questionnairDefinition;
    }

    public void setQuestionnairDefinition(QuestionnairDefinition questionnairDefinition) {
        this.questionnairDefinition = questionnairDefinition;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Integer getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Integer answersId) {
        this.answersId = answersId;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private Set<BrowsedElement> browsedElements;
        private DateTime submitDate;
        private Study study;
        private QuestionnairDefinition questionnairDefinition;
        private Participant participant;
        private Integer answersId;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder browsedElements(Set<BrowsedElement> browsedElements) {
            this.browsedElements = browsedElements;
            return this;
        }

        public Builder submitDate(DateTime submitDate) {
            this.submitDate = submitDate;
            return this;
        }

        public Builder answersId(Integer answersId) {
            this.answersId = answersId;
            return this;
        }

        public Builder study(Study study) {
            this.study = study;
            return this;
        }

        public Builder questionnairDefinition(QuestionnairDefinition questionnairDefinition) {
            this.questionnairDefinition = questionnairDefinition;
            return this;
        }

        public Builder participant(Participant participant) {
            this.participant = participant;
            return this;
        }

        public Questionnair build() {
            Questionnair questionnair = new Questionnair();
            questionnair.setId(id);
            questionnair.status = status;
            questionnair.browsedElements = browsedElements;
            questionnair.submitDate = submitDate;
            questionnair.study = study;
            questionnair.questionnairDefinition = questionnairDefinition;
            questionnair.participant = participant;
            questionnair.answersId = answersId;
            return questionnair;
        }
    }
}

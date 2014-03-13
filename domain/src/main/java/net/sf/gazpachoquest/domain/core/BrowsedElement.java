package net.sf.gazpachoquest.domain.core;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;

@Entity
@Table(name = "browsedelement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BrowsedElement extends AbstractAuditable {

    private static final long serialVersionUID = 8807488300208839486L;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Questionnair questionnair;

    @Basic
    protected Boolean last;

    public BrowsedElement() {
        super();
    }

    public Questionnair getRespondent() {
        return questionnair;
    }

    public void setRespondent(Questionnair questionnair) {
        this.questionnair = questionnair;
    }

    public Boolean isLast() {
        return last;
    }

    public void setLast(Boolean actual) {
        last = actual;
    }

    public static BuilderImpl withProps() {
        return new BuilderImpl();
    }

    public static class BuilderImpl {
        private Integer id;
        private Questionnair questionnair;
        private Boolean last;

        public BuilderImpl questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public BuilderImpl id(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl last(Boolean last) {
            this.last = last;
            return this;
        }

        public BrowsedElement build() {
            BrowsedElement browsedElement = new BrowsedElement();
            browsedElement.setId(id);
            browsedElement.questionnair = questionnair;
            browsedElement.last = last;
            return browsedElement;
        }
    }
}
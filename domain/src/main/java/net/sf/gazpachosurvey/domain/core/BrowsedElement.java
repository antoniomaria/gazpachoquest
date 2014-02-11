package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;

@Entity
@Table(name = "browsedelement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BrowsedElement extends AbstractAuditable {

    private static final long serialVersionUID = 8807488300208839486L;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Questionnair questionnair;

    @Basic
    protected boolean last;

    public BrowsedElement() {
        super();
    }

    public Questionnair getRespondent() {
        return questionnair;
    }

    public void setRespondent(Questionnair questionnair) {
        this.questionnair = questionnair;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean actual) {
        last = actual;
    }

    public static class Builder {
        private Questionnair questionnair;
        private boolean last;

        public Builder questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public Builder last(boolean last) {
            this.last = last;
            return this;
        }

        public BrowsedElement build() {
            BrowsedElement browsedElement = new BrowsedElement();
            browsedElement.questionnair = questionnair;
            browsedElement.last = last;
            return browsedElement;
        }
    }
}

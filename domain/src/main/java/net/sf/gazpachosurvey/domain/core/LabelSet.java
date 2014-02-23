package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class LabelSet extends AbstractPersistable {

    private static final long serialVersionUID = -8780599348940056785L;

    @Basic(optional = false)
    private String name;

    @OneToMany(mappedBy = "labelSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "sort_order")
    private List<Label> labels;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    public LabelSet() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Label> getLabels() {
        if (labels == null) {
            labels = new ArrayList<>();
        }
        return labels;
    }

    public void addLabel(Label label) {
        getLabels().add(label);
        label.setLabelSet(this);
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}

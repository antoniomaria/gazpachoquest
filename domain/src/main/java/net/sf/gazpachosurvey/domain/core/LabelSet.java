package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class LabelSet extends AbstractPersistable {

    private static final long serialVersionUID = -8780599348940056785L;

    @Basic(optional = false)
    private String name;

    @OneToMany(mappedBy = "labelSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "sort_order")
    private List<Label> labels;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
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

    public void addLabel(int index, Label label) {
        if (labels == null) {
            this.labels = new ArrayList<>();
        }
        if (labels.isEmpty() || index > labels.size()) {
            labels.add(label);
        } else if (index > 0) {
            labels.add(index - 1, label);
        } else { // Negative amount or zero
            labels.add(0, label);
        }
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

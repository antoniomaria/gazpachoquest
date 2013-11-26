package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.List;

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

    private String name;

    @OneToMany(mappedBy = "labelSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "sort_order")
    private List<Label> labels;

    @Enumerated(EnumType.STRING)
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

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void addLabel(Label label) {
        if (!getLabels().contains(label)) {
            labels.add(label);
            label.setLabelSet(this);
        }
    }

}

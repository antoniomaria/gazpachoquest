package net.sf.gazpachosurvey.domain.core;

import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.i18.LabelTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Label extends AbstractPersistable {

    private static final long serialVersionUID = -7124703628441903468L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LabelSet labelSet;

    @Basic(optional = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private Language language;

    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language")
    private Map<Language, LabelTranslation> translations;

    public Label() {
        super();
    }

    public Map<Language, LabelTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<Language, LabelTranslation> translations) {
        this.translations = translations;
    }

    public LabelSet getLabelSet() {
        return labelSet;
    }

    public void setLabelSet(LabelSet labelSet) {
        this.labelSet = labelSet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}

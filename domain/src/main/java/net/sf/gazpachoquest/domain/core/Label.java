package net.sf.gazpachoquest.domain.core;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.i18.LabelTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.Language;

@Entity
public class Label extends AbstractLocalizable<LabelTranslation, LabelLanguageSettings> {

    private static final long serialVersionUID = -7124703628441903468L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LabelSet labelSet;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private LabelLanguageSettings languageSettings;

    @OneToMany(mappedBy = "label", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, LabelTranslation> translations;

    public Label() {
        super();
    }

    @Override
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

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public LabelLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(LabelLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private LabelSet labelSet;
        private Language language;
        private LabelLanguageSettings languageSettings;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder labelSet(LabelSet labelSet) {
            this.labelSet = labelSet;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(LabelLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Label build() {
            Label label = new Label();
            label.setId(id);
            label.labelSet = labelSet;
            label.language = language;
            label.languageSettings = languageSettings;
            return label;
        }
    }
}

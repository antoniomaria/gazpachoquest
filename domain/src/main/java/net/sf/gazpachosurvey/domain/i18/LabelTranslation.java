package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class LabelTranslation extends AbstractPersistable implements Translation<LabelLanguageSettings> {

    private static final long serialVersionUID = -7571602125652099550L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Label label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    @Embedded
    private LabelLanguageSettings languageSettings;

    public LabelTranslation() {
        super();
    }

    public Label getLabel() {
        if (label == null) {
            this.label = new Label();
        }
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LabelLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(LabelLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getLabel().getId();
    }

    public static Builder with(){
        return new Builder();
    }
    
    public static class Builder implements TranslationBuilder<LabelTranslation, LabelLanguageSettings> {
        private Label label;
        private Language language;
        private LabelLanguageSettings languageSettings;

        public Builder label(Label label) {
            this.label = label;
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

        public LabelTranslation build() {
            LabelTranslation labelTranslation = new LabelTranslation();
            labelTranslation.label = label;
            labelTranslation.language = language;
            labelTranslation.languageSettings = languageSettings;
            return labelTranslation;
        }

        @Override
        public TranslationBuilder<LabelTranslation, LabelLanguageSettings> translatedEntityId(Integer entityId) {
            return label(Label.with().id(entityId).build());
        }
    }
}

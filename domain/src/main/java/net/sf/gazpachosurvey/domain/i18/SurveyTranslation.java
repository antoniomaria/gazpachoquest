package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class SurveyTranslation extends AbstractPersistable implements Translation<SurveyLanguageSettings> {

    private static final long serialVersionUID = -1926161817588270977L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @Enumerated(EnumType.STRING)
    @Column(insertable = true, updatable = true)
    private Language language;

    @Embedded
    private SurveyLanguageSettings languageSettings;

    public SurveyTranslation() {
        super();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public SurveyLanguageSettings getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new SurveyLanguageSettings();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(SurveyLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Language getLanguage() {

        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements TranslationBuilder<SurveyTranslation, SurveyLanguageSettings> {
        private Survey survey;
        private Language language;
        private SurveyLanguageSettings languageSettings;
        private Integer id;
        
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public Builder survey(Survey survey) {
            this.survey = survey;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(SurveyLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public SurveyTranslation build() {
            SurveyTranslation surveyTranslation = new SurveyTranslation();
            surveyTranslation.survey = survey;
            surveyTranslation.language = language;
            surveyTranslation.languageSettings = languageSettings;
            surveyTranslation.setId(id);
            return surveyTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            return survey(Survey.with().id(entityId).build());
        }

    }
}

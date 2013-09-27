package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class SurveyTranslation extends AbstractPersistable implements Translation<SurveyLanguageSettings> {

    private static final long serialVersionUID = -1926161817588270977L;

    @ManyToOne
    private Survey survey;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    @Embedded
    private SurveyLanguageSettings languageSettings;

    public SurveyTranslation() {
        super();
    }

    public SurveyTranslation(Survey survey, SurveyLanguageSettings languageSettings) {
        super();
        this.survey = survey;
        this.languageSettings = languageSettings;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public SurveyLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(SurveyLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}

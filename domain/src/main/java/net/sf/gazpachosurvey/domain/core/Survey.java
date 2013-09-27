package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.EntityStatus;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Survey extends AbstractLocalizable<SurveyTranslation, SurveyLanguageSettings> {

    private static final long serialVersionUID = 2560468772707058412L;

    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Embedded
    private SurveyLanguageSettings languageSettings;

    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SurveyRunning> surveysRunning;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language")
    private Map<Language, SurveyTranslation> translations;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "order_in_survey")
    private List<Page> pages;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Question> questions;

    public Survey() {
        super();
    }

    public Set<SurveyRunning> getSurveysRunning() {
        if (surveysRunning == null) {
            surveysRunning = new HashSet<>();
        }
        return surveysRunning;
    }

    public void setSurveysRunning(Set<SurveyRunning> surveysRunning) {
        this.surveysRunning = surveysRunning;
    }

    @Override
    public Map<Language, SurveyTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void addTranslation(Language language, SurveyLanguageSettings languageSettings) {
        SurveyTranslation translation = new SurveyTranslation();
        translation.setSurvey(this);
        translation.setLanguage(language);

        translation.setLanguageSettings(languageSettings);
        getTranslations().put(language, translation);
    }

    public void setTranslations(Map<Language, SurveyTranslation> translations) {
        this.translations = translations;
    }

    public void addSurveyRunning(SurveyRunning surveyRunning) {
        getSurveysRunning().add(surveyRunning);
        surveyRunning.setSurvey(this);
    }

    public void removeSurveyRunning(SurveyRunning surveyRunning) {
        getSurveysRunning().remove(surveyRunning);
        surveyRunning.setSurvey(null);
    }

    public List<Page> getPages() {
        if (pages == null) {
            pages = new ArrayList<>();
        }
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void addPage(Page page) {
        getPages().add(page);
        page.setSurvey(this);
    }

    public Set<Question> getQuestions() {
        if (questions == null) {
            questions = new HashSet<>();
        }
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public SurveyLanguageSettings getLanguageSettings() {
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

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private SurveyLanguageSettings languageSettings;
        private Language language;
        private Set<SurveyRunning> surveysRunning;
        private Map<Language, SurveyTranslation> translations;
        private List<Page> pages;
        private Set<Question> questions;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder languageSettings(SurveyLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder surveysRunning(Set<SurveyRunning> surveysRunning) {
            this.surveysRunning = surveysRunning;
            return this;
        }

        public Builder translations(Map<Language, SurveyTranslation> translations) {
            this.translations = translations;
            return this;
        }

        public Builder pages(List<Page> pages) {
            this.pages = pages;
            return this;
        }

        public Builder questions(Set<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Survey build() {
            Survey survey = new Survey();
            survey.setId(id);
            survey.status = status;
            survey.languageSettings = languageSettings;
            survey.language = language;
            survey.surveysRunning = surveysRunning;
            survey.translations = translations;
            survey.pages = pages;
            survey.questions = questions;
            return survey;
        }
    }
}

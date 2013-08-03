package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.*;

import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.types.Language;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class Survey extends AbstractAuditable<Integer> {

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

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderColumn(name = "sort_order")
    private List<Page> pages;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderColumn(name = "order_in_survey")
    private List<Question> questions;

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

    public Map<Language, SurveyTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslation(Language language,
            SurveyLanguageSettings languageSettings) {
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

    public List<Question> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

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

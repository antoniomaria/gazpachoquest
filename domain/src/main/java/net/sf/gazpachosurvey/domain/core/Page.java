package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
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
import javax.persistence.OrderColumn;

import net.sf.gazpachosurvey.domain.core.embeddables.PageLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.PageTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Page extends AbstractLocalizable<PageTranslation, PageLanguageSettings> {

    private static final long serialVersionUID = 5849288763708940985L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private PageLanguageSettings languageSettings;

    @OneToMany(mappedBy = "page", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, PageTranslation> translations;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderColumn(name = "order_in_page")
    private List<Question> questions;

    public Page() {
        super();
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

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
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
    public PageLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(PageLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Map<Language, PageTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<Language, PageTranslation> translations) {
        this.translations = translations;
    }

    public void addQuestion(Question question) {
        getQuestions().add(question);
        question.setPage(this);
    }

    @Override
    public void addTranslation(Language language, PageTranslation translation) {
        throw new UnsupportedOperationException();
        
    }

}

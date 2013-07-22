package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

@Entity
public class Question extends AbstractPersistable<Integer> {

    private Survey survey;

    private Question parent;

    private Page page;
    
    private Set<Question> subquestions;

    private Set<ResponseOption> responseOptions;

    private String title;
    
    private int sortOrder;

    boolean isRequired;
    
    private QuestionType type;

    private Map<Language, QuestionTranslation> translations;
    
    @Enumerated(EnumType.STRING)
    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    public Set<Question> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(Set<Question> subquestions) {
        this.subquestions = subquestions;
    }

    @ManyToOne
    public Question getParent() {
        return parent;
    }

    public void setParent(Question parent) {
        this.parent = parent;
    }

    @ManyToOne
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    public Set<ResponseOption> getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(Set<ResponseOption> responseOptions) {
        this.responseOptions = responseOptions;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language")
    public Map<Language, QuestionTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, QuestionTranslation> translations) {
        this.translations = translations;
    }
    
    public void setTranslation(Language language, String text) {
        QuestionTranslation translation = new QuestionTranslation();
        translation.setText(text);
        translation.setQuestion(this);
        translation.setLanguage(language);
        getTranslations().put(language, translation);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

}

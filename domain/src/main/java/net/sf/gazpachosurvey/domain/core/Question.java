package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.List;
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
import javax.persistence.OrderColumn;

import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

@Entity
public class Question extends AbstractPersistable<Integer> {

    private Survey survey;

    private Question parent;

    private Page page;
    
    private List<Question> subquestions;

    private List<Answer> answers;

    private String title;
    
    boolean isRequired;
    
    private QuestionType type;
    
    private Language language;

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
    @OrderColumn(name="order_in_subquestions")
    public List<Question> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(List<Question> subquestions) {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", orphanRemoval = true)
    @OrderColumn(name = "order_in_question")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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

    @Enumerated(EnumType.STRING)
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
    

}

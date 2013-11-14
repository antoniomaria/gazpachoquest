package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
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

import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

import org.springframework.util.Assert;

@Entity
public class Question extends AbstractLocalizable<QuestionTranslation, QuestionLanguageSettings> {

    private static final long serialVersionUID = -4372634574851905803L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @ManyToOne
    private Question parent;

    @ManyToOne
    private QuestionGroup questionGroup;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "order_in_subquestions")
    private List<Question> subquestions;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_in_question")
    private List<Answer> answers;

    private Boolean isRequired;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private QuestionLanguageSettings languageSettings;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, QuestionTranslation> translations;

    public Question() {
        super();
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Question> getSubquestions() {
        if (subquestions == null) {
            subquestions = new ArrayList<>();
        }
        return subquestions;
    }

    public void setSubquestions(List<Question> subquestions) {
        this.subquestions = subquestions;
    }

    public Question getParent() {
        return parent;
    }

    public void setParent(Question parent) {
        this.parent = parent;
    }

    public QuestionGroup getPage() {
        return questionGroup;
    }

    public void setPage(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public List<Answer> getAnswers() {
        if (answers == null) {
            answers = new ArrayList<>();
        }
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Boolean isRequired() {
        return isRequired;
    }

    public void setRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public Map<Language, QuestionTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, QuestionTranslation> translations) {
        this.translations = translations;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public void addAnswer(Answer answer) {
        getAnswers().add(answer);
        answer.setQuestion(this);
    }

    public void addSubquestion(Question subquestion) {
        Assert.notNull(subquestion);
        subquestion.setLanguage(language);
        getSubquestions().add(subquestion);
        subquestion.setParent(this);
    }

    @Override
    public QuestionLanguageSettings getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettings();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public void addTranslation(Language language, QuestionTranslation translation) {
        translation.setQuestion(this);
        getTranslations().put(language, translation);

    }

}

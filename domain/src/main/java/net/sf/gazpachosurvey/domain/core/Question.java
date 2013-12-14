package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Question parent;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionGroup questionGroup;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "order_in_subquestions")
    private List<Question> subquestions;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_in_question")
    private List<QuestionOption> questionOptions;

    private Boolean isRequired;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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

    public QuestionGroup getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public List<QuestionOption> getQuestionOptions() {
        if (questionOptions == null) {
            questionOptions = new ArrayList<>();
        }
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
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

    public void addQuestionOption(QuestionOption questionOption) {
        Assert.notNull(questionOption);
        if (!getQuestionOptions().contains(questionOption)) {
            questionOptions.add(questionOption);
            questionOption.setQuestion(this);
        }

    }

    public void addSubquestion(Question subquestion) {
        Assert.notNull(subquestion);
        if (!getSubquestions().contains(subquestion)) {
            subquestion.setLanguage(language);
            subquestions.add(subquestion);
            subquestion.setParent(this);
        }
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

    public void addTranslation(Language language, QuestionTranslation translation) {
        translation.setQuestion(this);
        getTranslations().put(language, translation);
    }

}

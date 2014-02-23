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

import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.domain.support.QuestionnairElement;

import org.springframework.util.Assert;

@Entity
public class Question extends AbstractLocalizable<QuestionTranslation, QuestionLanguageSettings> implements
        QuestionnairElement {

    private static final long serialVersionUID = -4372634574851905803L;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    private Question parent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionGroup questionGroup;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "order_in_subquestions")
    private List<Question> subquestions;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_in_question")
    private List<QuestionOption> questionOptions;

    private Boolean required;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setRequired(Boolean isRequired) {
        required = isRequired;
    }

    public Boolean isRequired() {
        return required;
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

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String code;
        private Question parent;
        private QuestionGroup questionGroup;
        private List<Question> subquestions;
        private List<QuestionOption> questionOptions;
        private Boolean required;
        private QuestionType type;
        private Language language;
        private QuestionLanguageSettings languageSettings;
        private Map<Language, QuestionTranslation> translations;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder parent(Question parent) {
            this.parent = parent;
            return this;
        }

        public Builder questionGroup(QuestionGroup questionGroup) {
            this.questionGroup = questionGroup;
            return this;
        }

        public Builder subquestions(List<Question> subquestions) {
            this.subquestions = subquestions;
            return this;
        }

        public Builder questionOptions(List<QuestionOption> questionOptions) {
            this.questionOptions = questionOptions;
            return this;
        }

        public Builder required(Boolean required) {
            this.required = required;
            return this;
        }

        public Builder type(QuestionType type) {
            this.type = type;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(QuestionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder translations(Map<Language, QuestionTranslation> translations) {
            this.translations = translations;
            return this;
        }

        public Question build() {
            Question question = new Question();
            question.setId(id);
            question.code = code;
            question.parent = parent;
            question.questionGroup = questionGroup;
            question.subquestions = subquestions;
            question.questionOptions = questionOptions;
            question.required = required;
            question.type = type;
            question.language = language;
            question.languageSettings = languageSettings;
            question.translations = translations;
            return question;
        }
    }
}

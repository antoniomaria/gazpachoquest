package net.sf.gazpachoquest.domain.core;

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

import net.sf.gazpachoquest.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.domain.support.QuestionnairElement;
import net.sf.gazpachoquest.types.Language;

@Entity
public class QuestionGroup extends AbstractLocalizable<QuestionGroupTranslation, QuestionGroupLanguageSettings>
        implements QuestionnairElement {

    private static final long serialVersionUID = 5849288763708940985L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionnairDefinition questionnairDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private QuestionGroupLanguageSettings languageSettings;

    @OneToMany(mappedBy = "questionGroup", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, QuestionGroupTranslation> translations;

    @OneToMany(mappedBy = "questionGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderColumn(name = "order_in_questiongroup")
    private List<Question> questions;

    public QuestionGroup() {
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

    public QuestionnairDefinition getSurvey() {
        return questionnairDefinition;
    }

    public void setSurvey(QuestionnairDefinition questionnairDefinition) {
        this.questionnairDefinition = questionnairDefinition;
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
    public QuestionGroupLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionGroupLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Map<Language, QuestionGroupTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<Language, QuestionGroupTranslation> translations) {
        this.translations = translations;
    }

    public void addQuestion(Question question) {
        if (!getQuestions().contains(question)) {
            getQuestions().add(question);
            question.setQuestionGroup(this);
        }
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private QuestionnairDefinition questionnairDefinition;
        private Language language;
        private QuestionGroupLanguageSettings languageSettings;
        private Map<Language, QuestionGroupTranslation> translations;
        private List<Question> questions;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder questionnairDefinition(QuestionnairDefinition questionnairDefinition) {
            this.questionnairDefinition = questionnairDefinition;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(QuestionGroupLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder translations(Map<Language, QuestionGroupTranslation> translations) {
            this.translations = translations;
            return this;
        }

        public Builder questions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public QuestionGroup build() {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setId(id);
            questionGroup.questionnairDefinition = questionnairDefinition;
            questionGroup.language = language;
            questionGroup.languageSettings = languageSettings;
            questionGroup.translations = translations;
            questionGroup.questions = questions;
            return questionGroup;
        }
    }
}

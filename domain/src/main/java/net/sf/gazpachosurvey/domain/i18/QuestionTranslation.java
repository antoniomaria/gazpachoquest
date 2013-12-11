package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class QuestionTranslation extends AbstractPersistable implements Translation<QuestionLanguageSettings> {

    private static final long serialVersionUID = 4295351363647972048L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Enumerated(EnumType.STRING)

    @Column(insertable = false, updatable = false)
    private Language language;

    @Embedded
    private QuestionLanguageSettings languageSettings;

    public QuestionTranslation() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
    public QuestionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements TranslationBuilder<QuestionTranslation, QuestionLanguageSettings> {
        private Question question;
        private Language language;
        private QuestionLanguageSettings languageSettings;

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(QuestionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionTranslation build() {
            QuestionTranslation questionTranslation = new QuestionTranslation();
            questionTranslation.question = question;
            questionTranslation.language = language;
            questionTranslation.languageSettings = languageSettings;
            return questionTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            Question question = new Question();
            question.setId(entityId);
            return question(question);
        }
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getQuestion().getId();
    }
}

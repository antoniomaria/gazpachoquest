package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class QuestionGroupTranslation extends AbstractPersistable implements
        Translation<QuestionGroupLanguageSettings> {

    private static final long serialVersionUID = -2719163699375812306L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionGroup questionGroup;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private QuestionGroupLanguageSettings languageSettings;

    public QuestionGroupTranslation() {
        super();
    }

    public QuestionGroup getPage() {
        return questionGroup;
    }

    public void setPage(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public QuestionGroupLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionGroupLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static class Builder  implements TranslationBuilder<QuestionGroupTranslation, QuestionGroupLanguageSettings> { 
        private QuestionGroup questionGroup;
        private Language language;
        private QuestionGroupLanguageSettings languageSettings;

        public Builder questionGroup(QuestionGroup questionGroup) {
            this.questionGroup = questionGroup;
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

        public QuestionGroupTranslation build() {
            QuestionGroupTranslation questionGroupTranslation = new QuestionGroupTranslation();
            questionGroupTranslation.questionGroup = questionGroup;
            questionGroupTranslation.language = language;
            questionGroupTranslation.languageSettings = languageSettings;
            return questionGroupTranslation;
        }

        @Override
        public Builder translatedEntityId(
                Integer entityId) {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setId(entityId);
            return questionGroup(questionGroup);
        }
    }
}

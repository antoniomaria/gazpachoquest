package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class QuestionOptionTranslation extends AbstractPersistable implements Translation<QuestionOptionLanguageSettings>{

    private static final long serialVersionUID = 5809899129770049770L;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionOption questionOption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    @Embedded
    private QuestionOptionLanguageSettings languageSettings;

    public QuestionOptionTranslation() {
        super();
    }

    public QuestionOption getQuestionOption() {
        if (questionOption == null){
            this.questionOption = new QuestionOption();
        }
        return questionOption;
    }

    public void setQuestionOption(QuestionOption questionOption) {
        this.questionOption = questionOption;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public QuestionOptionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionOptionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getQuestionOption().getId();
    }

}

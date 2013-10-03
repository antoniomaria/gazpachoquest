package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class QuestionTranslation extends AbstractPersistable implements Translation<QuestionLanguageSettings>{

    private static final long serialVersionUID = 4295351363647972048L;

    @ManyToOne
    private Question question;

    @Enumerated(EnumType.STRING)
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public QuestionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }
    
}

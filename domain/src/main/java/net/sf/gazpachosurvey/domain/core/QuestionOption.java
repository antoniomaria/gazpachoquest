package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.Map;

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

import net.sf.gazpachosurvey.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class QuestionOption extends AbstractLocalizable<QuestionOptionTranslation, QuestionOptionLanguageSettings> {

    private static final long serialVersionUID = 2405587054509407178L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    private String code;

    @Embedded
    private QuestionOptionLanguageSettings languageSettings;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "questionOption", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, QuestionOptionTranslation> translations;

    public QuestionOption() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Map<Language, QuestionOptionTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, QuestionOptionTranslation> translations) {
        this.translations = translations;
    }

}

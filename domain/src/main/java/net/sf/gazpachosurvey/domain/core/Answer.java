package net.sf.gazpachosurvey.domain.core;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.i18.AnswerTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Answer extends AbstractPersistable<Integer> {

    private Question question;

    private String code;

    private String title;

    private Language language;

    private Map<Language, AnswerTranslation> translations;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language")
    public Map<Language, AnswerTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, AnswerTranslation> translations) {
        this.translations = translations;
    }

    public void setTranslation(Language language, String text) {
        AnswerTranslation translation = new AnswerTranslation();
        translation.setText(text);
        translation.setAnswer(this);
        translation.setLanguage(language);
        getTranslations().put(language, translation);
    }

}

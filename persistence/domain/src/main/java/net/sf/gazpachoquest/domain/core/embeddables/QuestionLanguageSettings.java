package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class QuestionLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = 3469710591786790179L;

    @Column(nullable = false)
    private String title;

    public QuestionLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

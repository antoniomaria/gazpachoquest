package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class QuestionOptionLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -7084726194267373517L;

    @Column(nullable = false)
    private String title;

    public QuestionOptionLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

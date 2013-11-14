package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

@Embeddable
public class QuestionGroupLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -3294430575682341044L;
    
    @Column(nullable = false)
    private String title;

    public QuestionGroupLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

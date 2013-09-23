package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

@Embeddable 
public class PageLanguageSettings implements LanguageSettings{

    @Column(nullable = false)
    private String title;

    public PageLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

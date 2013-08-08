package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PageLanguageSettings {

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

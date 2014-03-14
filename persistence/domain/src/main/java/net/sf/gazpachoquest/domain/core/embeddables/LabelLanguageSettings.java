package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class LabelLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -5372916220584777180L;

    @Column(nullable = false)
    private String title;

    public LabelLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

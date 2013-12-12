package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class LabelLanguageSettingsDTO implements LanguageSettings {

    private static final long serialVersionUID = 8022490578017125663L;

    private String title;

    public LabelLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

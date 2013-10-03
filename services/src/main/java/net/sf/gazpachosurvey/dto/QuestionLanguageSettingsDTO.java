package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionLanguageSettingsDTO implements LanguageSettings {

    private String title;

    public QuestionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

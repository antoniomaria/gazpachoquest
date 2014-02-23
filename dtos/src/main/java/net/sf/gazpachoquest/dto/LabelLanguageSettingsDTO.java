package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.LanguageSettingsDTO;

public class LabelLanguageSettingsDTO implements LanguageSettingsDTO {

    private static final long serialVersionUID = 8022490578017125663L;

    private String title;

    public LabelLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

}

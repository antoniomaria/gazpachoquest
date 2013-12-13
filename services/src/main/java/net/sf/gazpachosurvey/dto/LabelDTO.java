package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class LabelDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<LabelLanguageSettingsDTO> {

    private static final long serialVersionUID = 7715134426554617698L;

    private Language language;

    private LabelLanguageSettingsDTO languageSettings;

    public LabelDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LabelLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(LabelLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Language language;
        private String title;

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public LabelDTO build() {
            LabelDTO labelDTO = new LabelDTO();
            labelDTO.language = language;
            labelDTO.languageSettings = new LabelLanguageSettingsDTO();
            labelDTO.languageSettings.setTitle(title);
            return labelDTO;
        }
    }
}

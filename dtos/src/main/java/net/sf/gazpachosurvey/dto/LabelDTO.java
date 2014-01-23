package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class LabelDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<LabelLanguageSettingsDTO> {

    public static class Builder {
        private Language language;
        private String title;

        public LabelDTO build() {
            LabelDTO labelDTO = new LabelDTO();
            labelDTO.language = language;
            labelDTO.languageSettings = new LabelLanguageSettingsDTO();
            labelDTO.languageSettings.setTitle(title);
            return labelDTO;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }
    }

    private static final long serialVersionUID = 7715134426554617698L;

    public static Builder with() {
        return new Builder();
    }

    private Language language;

    private LabelLanguageSettingsDTO languageSettings;

    public LabelDTO() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public LabelLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final LabelLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }
}

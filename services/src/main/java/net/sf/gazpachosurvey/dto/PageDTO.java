package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class PageDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<PageLanguageSettingsDTO>{

    private static final long serialVersionUID = 4668205160387380803L;

    private Language language;

    private PageLanguageSettingsDTO languageSettings;

    public PageDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public PageLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(PageLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {

        Builder languageSettings(PageLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        PageLanguageSettingsDTO.Builder pageLanguageSettingsStart();

        PageDTO build();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private PageLanguageSettingsDTO languageSettings;

        @Override
        public BuilderImpl language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(PageLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public PageLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return PageLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }

        @Override
        public PageDTO build() {
            PageDTO pageDTO = new PageDTO();
            pageDTO.languageSettings = languageSettings;
            pageDTO.language = language;
            return pageDTO;
        }
    }
}

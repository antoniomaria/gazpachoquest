package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class QuestionGroupDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<QuestionGroupLanguageSettingsDTO>{

    private static final long serialVersionUID = 4668205160387380803L;

    private Language language;

    private QuestionGroupLanguageSettingsDTO languageSettings;

    public QuestionGroupDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public QuestionGroupLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionGroupLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {

        Builder languageSettings(QuestionGroupLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart();

        QuestionGroupDTO build();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private QuestionGroupLanguageSettingsDTO languageSettings;

        @Override
        public BuilderImpl language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(QuestionGroupLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return QuestionGroupLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }

        @Override
        public QuestionGroupDTO build() {
            QuestionGroupDTO questionGroupDTO = new QuestionGroupDTO();
            questionGroupDTO.languageSettings = languageSettings;
            questionGroupDTO.language = language;
            return questionGroupDTO;
        }
    }
}

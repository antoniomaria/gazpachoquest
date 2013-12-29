package net.sf.gazpachosurvey.dto;

import java.util.Set;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class QuestionnairDefinitionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<SurveyLanguageSettingsDTO> {

    public static class Builder {
        private Language language;
        private SurveyLanguageSettingsDTO languageSettings;
        private Set<Language> translationsSupported;

        public QuestionnairDefinitionDTO build() {
            QuestionnairDefinitionDTO questionnairDefinitionBean = new QuestionnairDefinitionDTO();
            questionnairDefinitionBean.languageSettings = languageSettings;
            questionnairDefinitionBean.language = language;
            questionnairDefinitionBean.translationsSupported = translationsSupported;
            return questionnairDefinitionBean;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(final SurveyLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder translationsSupported(final Set<Language> translationsSupported) {
            this.translationsSupported = translationsSupported;
            return this;
        }
    }

    private static final long serialVersionUID = -3516840919344719813L;

    public static Builder with() {
        return new Builder();
    }

    private Language language;

    private SurveyLanguageSettingsDTO languageSettings;

    private Set<Language> translationsSupported;

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public SurveyLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public Set<Language> getTranslationsSupported() {
        return translationsSupported;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final SurveyLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setTranslationsSupported(final Set<Language> translationsSupported) {
        this.translationsSupported = translationsSupported;
    }

    @Override
    public String toString() {
        return "QuestionnairDefinitionDTO [languageSettings=" + languageSettings + ", language=" + language + "]";
    }
}

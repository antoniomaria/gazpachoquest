package net.sf.gazpachosurvey.rest.beans;

import java.util.Set;

import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.types.Language;

public class QuestionnairDefinitionBean {

    public static class Builder {
        private Language language;
        private SurveyLanguageSettingsDTO languageSettings;
        private Set<Language> translationsSupported;

        public QuestionnairDefinitionBean build() {
            QuestionnairDefinitionBean questionnairDefinitionBean = new QuestionnairDefinitionBean();
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

    public static Builder with() {
        return new Builder();
    }

    private Language language;

    private SurveyLanguageSettingsDTO languageSettings;

    private Set<Language> translationsSupported;

    public Language getLanguage() {
        return language;
    }

    public SurveyLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public Set<Language> getTranslationsSupported() {
        return translationsSupported;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public void setLanguageSettings(final SurveyLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setTranslationsSupported(final Set<Language> translationsSupported) {
        this.translationsSupported = translationsSupported;
    }

    @Override
    public String toString() {
        return "QuestionnairDefinitionBean [languageSettings=" + languageSettings + ", language=" + language + "]";
    }
}

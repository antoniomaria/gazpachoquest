package net.sf.gazpachosurvey.rest.beans;

import java.util.Set;

import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.types.Language;

public class QuestionnairDefinitionBean {

    private SurveyLanguageSettingsDTO languageSettings;

    private Language language;

    private Set<Language> translationsSupported;

    public SurveyLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(SurveyLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Language> getTranslationsSupported() {
        return translationsSupported;
    }

    public void setTranslationsSupported(Set<Language> translationsSupported) {
        this.translationsSupported = translationsSupported;
    }

    public static Builder with() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "QuestionnairDefinitionBean [languageSettings=" + languageSettings + ", language=" + language + "]";
    }

    public static class Builder {
        private SurveyLanguageSettingsDTO languageSettings;
        private Language language;
        private Set<Language> translationsSupported;

        public Builder languageSettings(SurveyLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder translationsSupported(Set<Language> translationsSupported) {
            this.translationsSupported = translationsSupported;
            return this;
        }

        public QuestionnairDefinitionBean build() {
            QuestionnairDefinitionBean questionnairDefinitionBean = new QuestionnairDefinitionBean();
            questionnairDefinitionBean.languageSettings = languageSettings;
            questionnairDefinitionBean.language = language;
            questionnairDefinitionBean.translationsSupported = translationsSupported;
            return questionnairDefinitionBean;
        }
    }
}

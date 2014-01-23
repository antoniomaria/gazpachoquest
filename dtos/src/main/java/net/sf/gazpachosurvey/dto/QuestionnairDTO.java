package net.sf.gazpachosurvey.dto;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.Language;

public class QuestionnairDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = 1067156345771109606L;

    private Language language;

    private Set<Language> supportedLanguages;

    private QuestionnairDefinitionLanguageSettingsDTO languageSettings;

    public QuestionnairDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Language> getSupportedLanguages() {
        if (supportedLanguages == null) {
            this.supportedLanguages = new HashSet<>();
        }
        return supportedLanguages;
    }

    public void setSupportedLanguages(Set<Language> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    public void addSupportedLanguage(Language language) {
        getSupportedLanguages().add(language);
    }

    public QuestionnairDefinitionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(QuestionnairDefinitionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

}

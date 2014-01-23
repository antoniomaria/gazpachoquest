package net.sf.gazpachosurvey.dto.support;

import net.sf.gazpachosurvey.types.Language;

public interface IdentifiableLocalizable<LSD extends LanguageSettingsDTO> extends Identifiable {

    Language getLanguage();

    LSD getLanguageSettings();

    void setLanguage(Language language);

    void setLanguageSettings(LSD languageSettings);
}

package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.types.Language;

public interface IdentifiableLocalizable<LSD extends LanguageSettingsDTO> extends Identifiable {

    Language getLanguage();

    LSD getLanguageSettings();

    void setLanguage(Language language);

    void setLanguageSettings(LSD languageSettings);
}

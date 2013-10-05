package net.sf.gazpachosurvey.dto.support;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.types.Language;

public interface IdentifiableLocalizable<LSD extends LanguageSettings> extends Identifiable{

    Language getLanguage();

    void setLanguage(Language language);
    
    LSD getLanguageSettings();

    void setLanguageSettings(LSD languageSettings);
}

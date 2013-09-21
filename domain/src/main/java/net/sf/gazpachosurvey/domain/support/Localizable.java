package net.sf.gazpachosurvey.domain.support;

import java.io.Serializable;
import java.util.Map;

import net.sf.gazpachosurvey.types.Language;

public interface Localizable<ID extends Serializable, LS extends LanguageSettings, TR extends Translation<LS>>
        extends Persistable<ID> {

    Language getLanguage();

    void setLanguage(Language language);
    
    LS getLanguageSettings();

    Map<Language, TR> getTranslations();

    void setLanguageSettings(LS languageSettings);


}

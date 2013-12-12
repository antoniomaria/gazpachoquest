package net.sf.gazpachosurvey.domain.support;

import java.util.Map;

import net.sf.gazpachosurvey.types.Language;

public interface Localizable<LS extends LanguageSettings, TR extends Translation<LS>> extends Persistable {

    Language getLanguage();

    void setLanguage(Language language);

    LS getLanguageSettings();

    Map<Language, TR> getTranslations();

    void setLanguageSettings(LS languageSettings);

}

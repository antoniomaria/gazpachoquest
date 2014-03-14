package net.sf.gazpachoquest.domain.support;

import java.util.Map;

import net.sf.gazpachoquest.types.Language;

public interface Localizable<LS extends LanguageSettings, TR extends Translation<LS>> extends Persistable {

    Language getLanguage();

    void setLanguage(Language language);

    LS getLanguageSettings();

    Map<Language, TR> getTranslations();

    void setLanguageSettings(LS languageSettings);

}

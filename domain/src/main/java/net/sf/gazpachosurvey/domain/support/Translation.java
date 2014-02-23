package net.sf.gazpachosurvey.domain.support;

import net.sf.gazpachoquest.types.Language;

public interface Translation<LS extends LanguageSettings> extends Persistable {
    LS getLanguageSettings();

    void setLanguageSettings(LS languageSettings);

    Language getLanguage();

    void setLanguage(Language language);

    Integer getTranslatedEntityId();
}

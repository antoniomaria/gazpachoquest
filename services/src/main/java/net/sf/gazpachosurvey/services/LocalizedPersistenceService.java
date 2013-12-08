package net.sf.gazpachosurvey.services;

import java.util.Set;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.types.Language;

public interface LocalizedPersistenceService<T extends Persistable, LS extends LanguageSettings> extends
        PersistenceService<T> {

    T findOne(Integer id, Language language);

    void saveTranslation(Integer entityId, Language language, LS languageSettings);

    Set<Language> translationsSupported(Integer entityId);
}

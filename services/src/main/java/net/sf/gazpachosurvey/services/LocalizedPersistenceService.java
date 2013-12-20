package net.sf.gazpachosurvey.services;

import java.util.Set;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

public interface LocalizedPersistenceService<T extends Persistable, TR extends Translation<LS>, LS extends LanguageSettings>
        extends PersistenceService<T> {

    T findOne(Integer id, Language language);

    Set<Language> translationsSupported(Integer entityId);

    TR saveTranslation(TR translation);
}

package net.sf.gazpachoquest.services;

import java.util.Set;

import net.sf.gazpachoquest.domain.support.LanguageSettings;
import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.types.Language;

public interface LocalizedPersistenceService<T extends Persistable, TR extends Translation<LS>, LS extends LanguageSettings>
        extends PersistenceService<T> {

    T findOne(Integer id, Language language);

    TR saveTranslation(TR translation);

    Set<Language> translationsSupported(Integer entityId);
}

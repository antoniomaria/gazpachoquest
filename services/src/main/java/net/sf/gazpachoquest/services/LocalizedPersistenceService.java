package net.sf.gazpachoquest.services;

import java.util.Set;

import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.domain.support.Translation;

public interface LocalizedPersistenceService<T extends Persistable, TR extends Translation<LS>, LS extends LanguageSettings>
        extends PersistenceService<T> {

    T findOne(Integer id, Language language);

    TR saveTranslation(TR translation);

    Set<Language> translationsSupported(Integer entityId);
}

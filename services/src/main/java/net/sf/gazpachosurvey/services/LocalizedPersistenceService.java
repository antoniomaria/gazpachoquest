package net.sf.gazpachosurvey.services;

import java.util.Set;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.types.Language;

public interface LocalizedPersistenceService<D extends Identifiable, LSD extends LanguageSettings> extends PersistenceService<D> {

    D findOne(Integer id, Language language);
    
    void saveTranslation(Integer entityId, Language language,
            LSD languageSettingsDTO);

     Set<Language> languages(Integer entityId);
}

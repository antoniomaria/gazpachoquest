package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.types.Language;

public interface LocalizedPersistenceService<D extends Identifiable> extends PersistenceService<D> {

    D findOne(Integer id, Language language);
}

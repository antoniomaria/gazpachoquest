package net.sf.gazpachosurvey.services;

import java.io.Serializable;

import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.types.Language;

public interface LocalizedPersistenceService<D extends Identifiable<ID>, ID extends Serializable> extends PersistenceService<D, ID> {

    D findOne(ID id, Language language);
}

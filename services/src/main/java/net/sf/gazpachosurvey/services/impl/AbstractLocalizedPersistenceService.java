package net.sf.gazpachosurvey.services.impl;

import java.io.Serializable;
import net.sf.gazpachosurvey.services.LocalizedPersistenceService;
import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.repository.support.LocalizedRepository;
import net.sf.gazpachosurvey.types.Language;

public abstract class AbstractLocalizedPersistenceService<T extends Persistable<ID>, D extends Identifiable<ID>, ID extends Serializable>
        extends AbstractPersistenceService<T, D, ID> implements LocalizedPersistenceService<D, ID>{

    protected LocalizedRepository<T, ID> localizedRepository;

    protected AbstractLocalizedPersistenceService(
            LocalizedRepository<T, ID> repository, Class<T> entityClazz,
            Class<D> dtoClazz) {
        super(repository, entityClazz, dtoClazz);
        localizedRepository = repository;
    }
    
    public D findOne(ID id, Language language){
        T entity = localizedRepository.findOne(id,language);
        D dto = null;
        if (entity != null){
            dto = mapper.map(entity, dtoClazz);    
        }
        return dto;
    }

}

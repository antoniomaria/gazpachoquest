package net.sf.gazpachosurvey.services.impl;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractPersistenceService<T extends Persistable<ID>, D extends Identifiable<ID>, ID extends Serializable>
        implements PersistenceService<D, ID> {

    protected final GenericRepository<T, ID> repository;

    protected final Class<D> typeParameterClass;

    @Autowired
    private Mapper mapper;

    public AbstractPersistenceService(GenericRepository<T, ID> repository, Class<D> typeParameterClass) {
        this.repository = repository;
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public List<D> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public D findOne(ID id) {
        T entity = repository.findOne(id);
        String schenarioName = entity.getClass().getSimpleName() + ".default";
        D dto = mapper.map(entity, typeParameterClass, schenarioName);
        return dto;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    @Override
    public D save(D entity) {
        D dto = mapper.map(entity, typeParameterClass, schenarioName);
        
        T savedEntity = repository.save(entity);
        
        D dto = mapper.map(entity, typeParameterClass, schenarioName);
        return dto;
    }

    @Override
    public List<D> findByExample(D entity, SearchParameters searchParameters) {
        // TODO Auto-generated method stub
        return null;
    }

}

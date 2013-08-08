package net.sf.gazpachosurvey.services.impl;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.domain.support.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;

//import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

public class AbstractPersistenceService<T extends Identifiable<ID>, ID extends Serializable> implements
        PersistenceService<T, ID> {

    protected final GenericRepository<T, ID> repository;

    public AbstractPersistenceService(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public T findOne(ID id) {
        return repository.findOne(id);
    }

    @Override
    public long count() {
        return this.repository.count();
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> findByExample(T entity, SearchParameters searchParameters) {
        return repository.findByExample(entity, searchParameters);
    }

}

package net.sf.gazpachosurvey.services.impl;

import java.util.List;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;

public abstract class AbstractPersistenceService<T extends Persistable> implements PersistenceService<T> {

    protected final GenericRepository<T> repository;

    protected AbstractPersistenceService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public abstract T save(T entity);

    @Override
    public List<T> findByExample(T entity, SearchParameters searchParameters) {
        return repository.findByExample(entity, searchParameters);
    }

    @Override
    public T findOneByExample(T entity, SearchParameters searchParameters) {
        return repository.findOneByExample(entity, searchParameters);
    }

}

package net.sf.gazpachoquest.services.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.repository.qbe.SearchParameters;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.services.PersistenceService;

public abstract class AbstractPersistenceService<T extends Persistable> implements PersistenceService<T> {

    protected final GenericRepository<T> repository;

    protected AbstractPersistenceService(final GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(final Integer id) {
        repository.delete(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findByExample(final T entity, final SearchParameters searchParameters) {
        return repository.findByExample(entity, searchParameters);
    }

    @Override
    public T findOne(final Integer id) {
        return repository.findOne(id);
    }

    @Override
    public T findOneByExample(final T entity, final SearchParameters searchParameters) {
        return repository.findOneByExample(entity, searchParameters);
    }

    @Override
    public abstract T save(T entity);

}

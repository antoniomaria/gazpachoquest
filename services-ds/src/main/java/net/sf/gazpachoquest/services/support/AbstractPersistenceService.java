package net.sf.gazpachoquest.services.support;

import java.util.List;
import java.util.Optional;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.repository.support.JPARepository;
import net.sf.gazpachoquest.services.PersistenceService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public abstract class AbstractPersistenceService<T extends Persistable> implements PersistenceService<T> {

    protected JPARepository<T> repository;

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
    public Optional<T> findOneByExample(final T entity, final SearchParameters searchParameters) {
        return repository.findOneByExample(entity, searchParameters);
    }

    @Override
    public Page<T> findPaginated(Integer pageNumber, Integer size) {
        return repository.findAll(new PageRequest(pageNumber - 1, size));
    }

    @Override
    public abstract T save(T entity);

    @Override
    public void deleteByExample(final T entity, final SearchParameters searchParameters) {
        repository.deleteByExample(entity, searchParameters);
    }

}

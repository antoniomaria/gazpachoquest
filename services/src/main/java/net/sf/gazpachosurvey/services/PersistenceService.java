package net.sf.gazpachosurvey.services;

import java.util.List;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

public interface PersistenceService<T extends Persistable> {
    List<T> findAll();

    T findOne(Integer id);

    long count();

    void delete(Integer id);

    T save(T entity);

    List<T> findByExample(T example, SearchParameters searchParameters);

    T findOneByExample(T example, SearchParameters searchParameters);
}

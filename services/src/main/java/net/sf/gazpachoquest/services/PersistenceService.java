package net.sf.gazpachoquest.services;

import java.util.List;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.support.SearchParameters;

public interface PersistenceService<T extends Persistable> {
    long count();

    void delete(Integer id);

    List<T> findAll();

    List<T> findByExample(T example, SearchParameters searchParameters);

    T findOne(Integer id);

    T findOneByExample(T example, SearchParameters searchParameters);

    T save(T entity);
}

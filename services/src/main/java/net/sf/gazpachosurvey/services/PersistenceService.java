package net.sf.gazpachosurvey.services;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.domain.support.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
//import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

public interface PersistenceService<T extends Identifiable<ID>, ID extends Serializable> {
    List<T> findAll();

    T findOne(ID id);

    long count();

    void delete(ID id);

    T save(T entity);

    List<T> findByExample(T entity, SearchParameters searchParameters);
}

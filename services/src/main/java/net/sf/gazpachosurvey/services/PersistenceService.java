package net.sf.gazpachosurvey.services;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

public interface PersistenceService<D extends Identifiable<ID>, ID extends Serializable> {
    List<D> findAll();

    D findOne(ID id);

    long count();

    void delete(ID id);

    ID add(D dto);

    List<D> findByExample(D dto, SearchParameters searchParameters);
}

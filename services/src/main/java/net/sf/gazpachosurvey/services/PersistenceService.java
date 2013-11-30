package net.sf.gazpachosurvey.services;

import java.util.List;

import net.sf.gazpachosurvey.dto.support.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

public interface PersistenceService<D extends Identifiable> {
    List<D> findAll();

    D findOne(Integer id);

    D findOne(Integer id, String schenario);

    long count();

    void delete(Integer id);

    D save(D dto);

    List<D> findByExample(D dto, SearchParameters searchParameters);

    D findOneByExample(D dto, SearchParameters searchParameters);
}

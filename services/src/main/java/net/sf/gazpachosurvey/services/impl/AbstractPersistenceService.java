package net.sf.gazpachosurvey.services.impl;

import java.io.Serializable;
import java.util.List;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractPersistenceService<T_DAO extends GenericRepository<T, ID>, T extends Persistable<ID>, D extends Identifiable<ID>, ID extends Serializable>
        implements PersistenceService<D, ID> {

    protected final GenericRepository<T, ID> repository;

    @Autowired
    private Mapper mapper;

    public AbstractPersistenceService(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<D> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public D findOne(ID id) {
        T entity = repository.findOne(id);

       D dto = mapper.map(entity, f());
        return null;
    }

    public  Class<D> f() {
        return LabelSetDTO.class.getClass();
    }

    public @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(ID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public D save(D entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<D> findByExample(D entity, SearchParameters searchParameters) {
        // TODO Auto-generated method stub
        return null;
    }

}

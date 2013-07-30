package net.sf.gazpachosurvey.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.AbstractPersistable;

import net.sf.gazpachosurvey.domain.support.Identifiable;
//import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;


public class AbstractPersistenceService<T extends Identifiable<ID>, ID extends Serializable>
        implements PersistenceService<T, ID> {

    protected final GenericRepository<T, ID> repository;

    public AbstractPersistenceService(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public T findOne(ID id) {
        return repository.findOne(id);
    }

    public long count() {
        return this.repository.count();
    }

    public void delete(ID id) {
        repository.delete(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }
    
    public List<T> findByExample(T entity, SearchParameters searchParameters){
        return repository.findByExample(entity, searchParameters);
    }

}

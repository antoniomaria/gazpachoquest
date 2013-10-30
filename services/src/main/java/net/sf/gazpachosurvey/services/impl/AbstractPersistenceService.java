package net.sf.gazpachosurvey.services.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.PersistenceService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPersistenceService<T extends Persistable, D extends Identifiable>
        implements PersistenceService<D> {

    protected final GenericRepository<T> repository;

    protected final Class<D> dtoClazz;

    protected final Class<T> entityClazz;

    @Autowired
    protected Mapper mapper;

    protected AbstractPersistenceService(GenericRepository<T> repository,
            Class<T> entityClazz, Class<D> dtoClazz) {
        this.repository = repository;
        this.dtoClazz = dtoClazz;
        this.entityClazz = entityClazz;
    }

    @Override
    public List<D> findAll() {
        List<T> entities = repository.findAll();
        List<D> entitiesDtos = new ArrayList<>();
        for (T entity : entities) {
            D dto = mapper.map(entity, dtoClazz);
            entitiesDtos.add(dto);
        }
        return entitiesDtos;
    }

    @Override
    public D findOne(Integer id) {
        T entity = repository.findOne(id);
        return  map(entity);
    }

    @Override
    public D findOne(Integer id, String schenario) {
        T entity = repository.findOne(id);
        D dto = null;
        if (entity != null) {
            dto = mapper.map(entity, dtoClazz, schenario);
        }
        return dto;
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
    public D save(D dto) {
        T entity = mapper.map(dto, entityClazz);
        T savedEntity = repository.save(entity);
        return mapper.map(savedEntity, dtoClazz);
    }

    @Override
    public List<D> findByExample(D dto, SearchParameters searchParameters) {
        T entity = mapper.map(dto, entityClazz);
        List<T> results = repository.findByExample(entity, searchParameters);
        return map(results);
    }

    @Override
    public D findOneByExample(D dto, SearchParameters searchParameters) {
        T entity = mapper.map(dto, entityClazz);
        T found = repository.findOneByExample(entity, searchParameters);
        return map(found);
    }
    
    protected List<D> map(final List<T> list) {
        List<D> mappedList = new ArrayList<D>();
        for (T entity: list) {
            D dto = mapper.map(entity, dtoClazz);
            mappedList.add(dto);
        }
        return mappedList;
    }

    private D map(T entity) {
        D dto = null;
        if (entity != null) {
            dto = mapper.map(entity, dtoClazz);
        }
        return dto;
    }

}

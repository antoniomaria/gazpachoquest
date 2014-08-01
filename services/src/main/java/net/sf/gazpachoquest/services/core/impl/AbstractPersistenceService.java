/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.core.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.services.PersistenceService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

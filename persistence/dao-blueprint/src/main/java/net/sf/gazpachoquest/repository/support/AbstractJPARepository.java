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
package net.sf.gazpachoquest.repository.support;

import java.util.List;
import java.util.Optional;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.apache.aries.jpa.supplier.EmSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

public abstract class AbstractJPARepository<T extends Persistable> implements JPARepository<T> {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(AbstractJPARepository.class);

    protected Class<T> domainType;

    protected AbstractJPARepository(Class<T> domainType) {
        logger.debug("Instance created");
        this.domainType = domainType;
    }

    @Override
    public long countByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Page<T> findByExample(final T example, final List<Range<?, ?>> ranges, final Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<T> findByExample(final T example, final Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> findByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> findOneByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends T> S save(final S entity) {
        getEm().get().persist(entity);
        getEm().get().flush();
        return entity;
    }

    @Override
    public void deleteByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub

    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public T findOne(Integer id) {
        Assert.notNull(id, "The given id must not be null!");
        return getEm().get().find(domainType, id);
    }

    public Page<T> findAll(PageRequest pageRequest) {
        return null;
    }

    protected abstract EmSupplier getEm();
}

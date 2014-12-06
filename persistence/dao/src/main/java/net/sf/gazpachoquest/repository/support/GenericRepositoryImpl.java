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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.ByExampleSpecification;
import net.sf.gazpachoquest.qbe.NamedQueryUtil;
import net.sf.gazpachoquest.qbe.PropertySelectorSpecification;
import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.RangeSpecification;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.apache.commons.lang3.Validate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@NoRepositoryBean
public class GenericRepositoryImpl<T extends Persistable> extends SimpleJpaRepository<T, Integer> implements
        GenericRepository<T> {

    private ByExampleSpecification byExampleSpecification;
    private final EntityManager em;
    private final JpaEntityInformation<T, ?> entityInformation;
    private NamedQueryUtil namedQueryUtil;

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given
     * {@link JpaEntityInformation}.
     */
    public GenericRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager,
            final NamedQueryUtil namedQueryUtil) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
        // provider =
        // DefaultPersistenceProvider.fromEntityManager(entityManager);
        // this.springDataRepositoryInterface = springDataRepositoryInterface;
        this.namedQueryUtil = namedQueryUtil;
        this.byExampleSpecification = new ByExampleSpecification(entityManager);
    }

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given
     * domain type.
     */
    protected GenericRepositoryImpl(final Class<T> domainClass, final EntityManager em) {
        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em, null);
    }

    @Override
    public T findOne(Integer id) {
        T entity = super.findOne(id);

        if (entity == null) {
            throw new EmptyResultDataAccessException(String.format("No %s entity with id %s exists!",
                    entityInformation.getJavaType(), id), 1);
        }
        return entity;
    }

    @Override
    public long countByExample(final T entity, final SearchParameters sp) {
        Validate.notNull(entity, "The entity cannot be null");
        if (sp.hasNamedQuery()) {
            return getNamedQueryUtil().numberByNamedQuery(sp).intValue();
        }
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExampleOnEntity(entity, sp));
        spec = RangeSpecification.andRangeIfSet(spec, sp.getRanges());
        spec = PropertySelectorSpecification.andPropertySelectorIfSet(spec, sp);
        return super.count(spec);
    }

    @Override
    public Page<T> findByExample(final T example, final List<Range<?, ?>> ranges, final Pageable pageable) {
        SearchParameters searchParameter = new SearchParameters();
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExampleOnEntity(example,
                searchParameter));
        spec = RangeSpecification.andRangeIfSet(spec, ranges);
        spec = PropertySelectorSpecification.andPropertySelectorIfSet(spec, searchParameter);
        return findAll(spec, pageable);
    }

    @Override
    public Page<T> findByExample(final T example, final Pageable pageable) {
        SearchParameters searchParameter = new SearchParameters();
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExampleOnEntity(example,
                searchParameter));
        spec = RangeSpecification.andRangeIfSet(spec, searchParameter.getRanges());
        spec = PropertySelectorSpecification.andPropertySelectorIfSet(spec, searchParameter);
        return findAll(spec, pageable);
    }

    @Override
    public List<T> findByExample(final T entity, final SearchParameters searchParameter) {
        Assert.notNull(searchParameter, "Search parameters required");
        if (searchParameter.hasNamedQuery()) {
            return getNamedQueryUtil().findByNamedQuery(searchParameter);
        }
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExampleOnEntity(entity,
                searchParameter));
        spec = RangeSpecification.andRangeIfSet(spec, searchParameter.getRanges());
        spec = PropertySelectorSpecification.andPropertySelectorIfSet(spec, searchParameter);
        return findAll(spec);
    }

    @Override
    public void deleteByExample(final T entity, final SearchParameters searchParameter) {
        List<T> entities = this.findByExample(entity, searchParameter);
        super.delete(entities);
    }

    @Override
    public Optional<T> findOneByExample(final T entity, final SearchParameters searchParameter) {
        Assert.notNull(searchParameter, "Search parameters required");
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExampleOnEntity(entity,
                searchParameter));
        spec = RangeSpecification.andRangeIfSet(spec, searchParameter.getRanges());
        spec = PropertySelectorSpecification.andPropertySelectorIfSet(spec, searchParameter);
        return Optional.ofNullable(super.findOne(spec));
    }

    @Override
    @Transactional
    public <S extends T> S saveWithFlush(S entity) {
        if (this.entityInformation.isNew(entity)) {
            this.em.persist(entity);
            flush();
            return entity;
        }
        entity = this.em.merge(entity);
        flush();
        return entity;
    }

    public List<T> saveWithoutFlush(final Iterable<? extends T> entities) {
        List<T> result = new ArrayList<T>();
        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(save(entity));
        }
        return result;
    }
    
    private NamedQueryUtil getNamedQueryUtil() {
        return namedQueryUtil;
    }
}

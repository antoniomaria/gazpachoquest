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

/**
 * 
 * The purpose of this class is to override the default behaviour of the spring JpaRepositoryFactory class. It will
 * produce a GenericRepositoryImpl object instead of SimpleJpaRepository.
 * 
 */

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import java.io.Serializable;

import javax.persistence.EntityManager;

import net.sf.gazpachoquest.qbe.NamedQueryUtil;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.util.Assert;

public class DefaultRepositoryFactory extends JpaRepositoryFactory {

    private final NamedQueryUtil namedQueryUtil;

    public DefaultRepositoryFactory(final EntityManager entityManager, final NamedQueryUtil namedQueryUtil) {
        super(entityManager);
        Assert.notNull(entityManager);
        Assert.notNull(namedQueryUtil);
        this.namedQueryUtil = namedQueryUtil;
    }

    @Override
    protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {

        if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
            return QueryDslJpaRepository.class;
        } else {
            return GenericRepositoryImpl.class;
        }
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
            final RepositoryMetadata metadata, final EntityManager entityManager) {

        Class<?> repositoryInterface = metadata.getRepositoryInterface();

        JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());

        if (isQueryDslExecutor(repositoryInterface)) {
            return new QueryDslJpaRepository(entityInformation, entityManager);
        } else {
            return new GenericRepositoryImpl(entityInformation, entityManager, namedQueryUtil); // custom
        }
    }

    /**
     * Returns whether the given repository interface requires a QueryDsl
     * specific implementation to be chosen.
     * 
     * @param repositoryInterface
     * @return
     */
    private boolean isQueryDslExecutor(final Class<?> repositoryInterface) {
        return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
    }

}

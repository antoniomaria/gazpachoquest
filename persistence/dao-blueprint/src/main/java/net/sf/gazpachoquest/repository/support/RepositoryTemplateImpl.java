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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.apache.aries.transaction.annotations.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RepositoryTemplateImpl<T extends Persistable> implements RepositoryTemplate<T> {

    @PersistenceContext(unitName = "gazpachoquest")
    protected EntityManager em;

    public RepositoryTemplateImpl() {
        System.out.println("RepositoryTemplateImpl instance created");
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
    @Transaction
    public <S extends T> S save(final S entity) {
        if (em == null) {
            System.out.println("Chungo entityManager not injected in RepositoryTemplateImpl ");
            return entity;
        }
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public void deleteByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub

    }

    public void setEm(final EntityManager em) {
        this.em = em;
    }

}

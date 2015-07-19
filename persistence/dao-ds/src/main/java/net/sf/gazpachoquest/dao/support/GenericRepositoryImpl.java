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
package net.sf.gazpachoquest.dao.support;

import java.util.List;
import java.util.Optional;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GenericRepositoryImpl<T extends Persistable> implements GenericRepository<T> {

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
    public <S extends T> S saveWithFlush(final S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByExample(final T entity, final SearchParameters sp) {
        // TODO Auto-generated method stub

    }

}

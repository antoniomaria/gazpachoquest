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

import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.SearchParameters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericRepository<T> {

    long countByExample(T entity, SearchParameters sp);

    Page<T> findByExample(T example, List<Range<?, ?>> ranges, Pageable pageable);

    Page<T> findByExample(T example, Pageable pageable);

    List<T> findByExample(T entity, SearchParameters sp);

    Optional<T> findOneByExample(T entity, SearchParameters sp);

    <S extends T> S saveWithFlush(S entity);

    void deleteByExample(T entity, SearchParameters sp);
}

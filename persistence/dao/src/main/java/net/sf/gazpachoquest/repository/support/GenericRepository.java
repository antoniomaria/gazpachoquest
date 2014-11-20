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

import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.support.SearchParameters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

    long countByExample(T entity, SearchParameters sp);

    Page<T> findByExample(T example, List<Range<?, ?>> ranges, Pageable pageable);

    Page<T> findByExample(T example, Pageable pageable);

    List<T> findByExample(T entity, SearchParameters sp);

    Optional<T> findOneByExample(T entity, SearchParameters sp);

    <S extends T> S saveWithFlush(S entity);

    void deleteByExample(T entity, SearchParameters sp);
}

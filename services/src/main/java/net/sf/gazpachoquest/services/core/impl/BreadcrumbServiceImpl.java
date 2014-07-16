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

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.repository.BreadcrumbRepository;
import net.sf.gazpachoquest.services.BreadcrumbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BreadcrumbServiceImpl extends AbstractPersistenceService<Breadcrumb> implements BreadcrumbService {

    @Autowired
    protected BreadcrumbServiceImpl(final BreadcrumbRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Breadcrumb findByQuestionnairIdAndPosition(Integer questionnairId, Integer position) {
        return ((BreadcrumbRepository) repository).findByQuestionnairIdAndPosition(questionnairId, position);
    }

    @Override
    @Transactional
    public List<Object[]> findLastAndPosition(Integer questionnairId) {
        return ((BreadcrumbRepository) repository).findLastAndPosition(questionnairId);
    }

    @Override
    @Transactional(readOnly = false)
    public Breadcrumb save(final Breadcrumb entity) {
        Breadcrumb fetched = null;
        if (entity.isNew()) {
            fetched = repository.save(entity);
        } else {
            fetched = repository.findOne(entity.getId());
            // Others properties are ignored. Breadcrumb is an inmutable
            // object
            fetched.setLast(entity.isLast());
        }
        return fetched;
    }

    @Override
    @Transactional
    public Integer count(Integer questionnairId) {
        return ((BreadcrumbRepository) repository).count(questionnairId);
    }
}

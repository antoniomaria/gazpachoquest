/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.permission.impl;

import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.repository.permission.ResearchPermissionRepository;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;
import net.sf.gazpachoquest.services.permission.ResearchPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResearchPermissionServiceImpl extends AbstractPersistenceService<ResearchPermission> implements
        ResearchPermissionService {

    @Autowired
    public ResearchPermissionServiceImpl(final ResearchPermissionRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public ResearchPermission save(final ResearchPermission researchPermission) {
        ResearchPermission existing = null;
        if (researchPermission.isNew()) {
            existing = repository.save(researchPermission);
        } else {
            existing = repository.findOne(researchPermission.getId());
            existing.setMask(researchPermission.getMask());
        }
        return existing;
    }

}

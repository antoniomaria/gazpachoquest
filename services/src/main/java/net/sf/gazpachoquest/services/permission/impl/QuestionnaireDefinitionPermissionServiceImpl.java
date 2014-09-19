/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.permission.impl;

import net.sf.gazpachoquest.domain.permission.QuestionnaireDefinitionPermission;
import net.sf.gazpachoquest.repository.permission.QuestionnaireDefinitionPermissionRepository;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;
import net.sf.gazpachoquest.services.permission.QuestionnaireDefinitionPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnaireDefinitionPermissionServiceImpl extends
        AbstractPersistenceService<QuestionnaireDefinitionPermission> implements QuestionnaireDefinitionPermissionService {

    @Autowired
    public QuestionnaireDefinitionPermissionServiceImpl(final QuestionnaireDefinitionPermissionRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnaireDefinitionPermission save(final QuestionnaireDefinitionPermission permission) {
        QuestionnaireDefinitionPermission existing = null;
        if (permission.isNew()) {
            existing = repository.save(permission);
        } else {
            existing = repository.findOne(permission.getId());
            existing.setMask(permission.getMask());
        }
        return existing;
    }

}

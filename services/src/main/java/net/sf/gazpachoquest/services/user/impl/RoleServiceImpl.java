/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.repository.user.RoleRepository;
import net.sf.gazpachoquest.services.RoleService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl extends AbstractPersistenceService<Role> implements RoleService {

    @Autowired
    public RoleServiceImpl(final RoleRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Role save(final Role role) {
        Role existing = null;
        if (role.isNew()) {
            existing = repository.save(role);
        } else {
            existing = repository.findOne(role.getId());
            existing.setName(role.getName());
        }
        return existing;
    }
}

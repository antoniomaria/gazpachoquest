/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.repository.user.GroupRepository;
import net.sf.gazpachoquest.services.GroupService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupServiceImpl extends AbstractPersistenceService<Group> implements GroupService {

    @Autowired
    public GroupServiceImpl(final GroupRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Group save(final Group group) {
        Group existing = null;
        if (group.isNew()) {
            existing = repository.save(group);
        } else {
            existing = repository.findOne(group.getId());
            existing.setName(group.getName());
        }
        return existing;
    }
}

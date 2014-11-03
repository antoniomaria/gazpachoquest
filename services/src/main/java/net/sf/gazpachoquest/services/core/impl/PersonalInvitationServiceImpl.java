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

import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.repository.PersonalInvitationRepository;
import net.sf.gazpachoquest.services.PersonalInvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonalInvitationServiceImpl extends AbstractPersistenceService<PersonalInvitation> implements PersonalInvitationService {

    @Autowired
    protected PersonalInvitationServiceImpl(final PersonalInvitationRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public PersonalInvitation save(final PersonalInvitation entity) {
        PersonalInvitation fetched = null;
        if (entity.isNew()) {
            fetched = repository.save(entity);
        } else {
            fetched = repository.findOne(entity.getId());
            fetched.setToken(entity.getToken());
            fetched.setStatus(entity.getStatus());
        }
        return fetched;
    }

}

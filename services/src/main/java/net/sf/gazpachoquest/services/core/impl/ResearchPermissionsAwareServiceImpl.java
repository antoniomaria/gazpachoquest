/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.core.impl;

import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.ResearchRepository;
import net.sf.gazpachoquest.services.ResearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchPermissionsAwareServiceImpl extends
        AbstractPermissionsAwarePersistenceService<Research, ResearchPermission> implements ResearchService {

    @Autowired
    public ResearchPermissionsAwareServiceImpl(final ResearchRepository repository) {
        super(repository);
    }

    @Override
    public Research save(Research research, Set<QuestionnairDefinition> questionnairDefinitions, Set<User> respondents) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

}

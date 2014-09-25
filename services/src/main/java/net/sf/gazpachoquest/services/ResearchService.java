/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services;

import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.EntityStatus;

public interface ResearchService extends PersistenceService<Research> {

    Research save(Research research, Set<QuestionnaireDefinition> questionnaireDefinitions, Set<User> respondents);

    void changeStatus(Integer researchId, EntityStatus newStatus);

    void addRespondent(Integer researchId, User respondent);

}

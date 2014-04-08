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
package net.sf.gazpachoquest.services;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;

public interface QuestionnairDefinitionService extends LocalizedPersistenceService<QuestionnairDefinition, QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {

    QuestionnairDefinition confirm(QuestionnairDefinition questionnairDefinition);

    long questionGroupsCount(Integer surveyId);

}

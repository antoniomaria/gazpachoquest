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
package net.sf.gazpachoquest.repository.dynamic;

import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;

public interface QuestionnairAnswersRepository {

    String ENTITY_NAME_PREFIX = "questionnair_answers_";

    void activeAllAnswers();

    void collectAnswers(QuestionnairDefinition questionnairDefinition);

    QuestionnairAnswers findByOne(Integer questionnairDefinitionId, Integer id);

    QuestionnairAnswers save(Integer questionnairDefinitionId, QuestionnairAnswers questionnairAnswers);

}

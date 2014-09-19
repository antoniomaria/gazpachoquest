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

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnaire;

public interface QuestionnaireAnswersService {

    Object findByQuestionCode(Questionnaire questionnaire, String questionCode);

    Map<String, Object> findByQuestionnaire(Questionnaire questionnaire);

    void save(Questionnaire questionnaire, String questionCode, Object answer);

}

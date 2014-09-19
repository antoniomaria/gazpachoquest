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

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.types.Language;

public interface QuestionService extends
        LocalizedPersistenceService<Question, QuestionTranslation, QuestionLanguageSettings> {

    Question findOneByPositionInSection(Integer sectionId, Integer position);

    Integer findPositionInSection(Integer questionId);

    List<Question> findBySectionId(Integer sectionId);

    List<Question> findInList(List<Integer> questionIds);

    List<Question> findInList(List<Integer> questionIds, Language language);

}

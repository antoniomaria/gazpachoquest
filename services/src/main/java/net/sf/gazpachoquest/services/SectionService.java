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

import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.SectionTranslation;

public interface SectionService extends
        LocalizedPersistenceService<Section, SectionTranslation, SectionLanguageSettings> {

    List<Section> findByQuestionnaireDefinitionId(Integer questionnaireDefinitionId);

    Section findOneByPositionInQuestionnaireDefinition(Integer questionnaireDefinitionId, Integer position);

    int positionInQuestionnaireDefinition(Integer sectionId);

    long questionsCount(Integer sectionId);
}

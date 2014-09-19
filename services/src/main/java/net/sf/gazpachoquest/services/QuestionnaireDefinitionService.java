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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;

import org.springframework.oxm.XmlMappingException;

public interface QuestionnaireDefinitionService
        extends
        LocalizedPersistenceService<QuestionnaireDefinition, QuestionnaireDefinitionTranslation, QuestionnaireDefinitionLanguageSettings> {

    QuestionnaireDefinition confirm(QuestionnaireDefinition questionnaireDefinition);

    int sectionsCount(Integer questionnairDefinitionId);

    Integer questionsCount(Integer questionnairDefinitionId);

    /**
     * Returns questions count group by question group for a given
     * questionnairDefinitionId
     * 
     * <pre>
     * [11, 2, 0] = [sectionId, questionCount, order_in_questionnair]
     * [10, 3, 1]
     * [9, 2, 2]
     * </pre>
     * 
     * @param questionnairDefinitionId
     * @return
     */
    List<Object[]> questionsCountGroupBySections(Integer questionnairDefinitionId);

    List<Question> getQuestions(Integer questionnairDefinitionId);

    void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException;

    QuestionnaireDefinition importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException, IOException;

}

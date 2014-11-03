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
import net.sf.gazpachoquest.types.Topology;

import org.springframework.oxm.XmlMappingException;

public interface QuestionnaireDefinitionService
        extends
        LocalizedPersistenceService<QuestionnaireDefinition, QuestionnaireDefinitionTranslation, QuestionnaireDefinitionLanguageSettings> {

    QuestionnaireDefinition confirm(QuestionnaireDefinition questionnaireDefinition);

    int sectionsCount(Integer questionnaireDefinitionId);

    Integer questionsCount(Integer questionnaireDefinitionId);

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
     * @param questionnaireDefinitionId
     * @return
     */
    List<Object[]> questionsCountGroupBySections(Integer questionnaireDefinitionId);

    List<Question> getQuestions(Integer questionnaireDefinitionId);

    void exportQuestionnaireDefinition(Integer questionnaireDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException;

    QuestionnaireDefinition importQuestionnaireDefinition(InputStream inputStream) throws XmlMappingException, IOException;

    Topology getTopology(Integer questionnaireDefinitionId);

}

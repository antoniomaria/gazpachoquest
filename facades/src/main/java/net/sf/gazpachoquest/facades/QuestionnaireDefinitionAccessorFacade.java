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
package net.sf.gazpachoquest.facades;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;
import net.sf.gazpachoquest.types.Language;

import org.springframework.oxm.XmlMappingException;

public interface QuestionnaireDefinitionAccessorFacade {

    QuestionnaireDefinitionDTO findOneQuestionnaireDefinition(Integer questionnaireDefinitionId);

    Set<Language> findQuestionnaireDefinitionTranslations(Integer questionnaireDefinitionId);

    QuestionDTO findOneQuestion(Integer questionId);

    void exportQuestionnaireDefinition(Integer questionnaireDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException;

    QuestionnaireDefinitionDTO importQuestionnaireDefinition(InputStream inputStream) throws XmlMappingException,
            IOException;

    PageDTO<QuestionnaireDefinitionDTO> findPaginated(Integer pageNumber, Integer size);

}

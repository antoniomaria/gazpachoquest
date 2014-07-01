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

import org.springframework.oxm.XmlMappingException;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.types.Language;

public interface QuestionnairDefinitionAccessorFacade {

    QuestionnairDefinitionDTO findOneQuestionnairDefinition(Integer questionnairDefinitionId);

    Set<Language> findQuestionnairDefinitionTranslations(Integer questionnairDefinitionId);

    QuestionDTO findOneQuestion(Integer questionId);

    void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException;

    QuestionnairDefinitionDTO importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException,
            IOException;

}

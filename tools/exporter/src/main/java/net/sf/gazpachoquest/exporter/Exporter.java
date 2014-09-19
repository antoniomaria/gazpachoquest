/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.exporter;

import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.gazpachoquest.facades.QuestionnaireDefinitionAccessorFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Exporter {

    private static Logger logger = LoggerFactory.getLogger(Exporter.class);

    @Autowired
    private QuestionnaireDefinitionAccessorFacade questionnaireDefinitionAccessorFacade;

    public void doExport() throws IOException {
        FileOutputStream fos = null;
        try {
            Integer questionnairDefinitionId = 12;
            fos = new FileOutputStream(String.format("target/QuestionnaireDefinition_%d.xml", questionnairDefinitionId));
            questionnaireDefinitionAccessorFacade.exportQuestionnaireDefinition(questionnairDefinitionId, fos);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}

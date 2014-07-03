/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.importer;

import java.io.FileInputStream;
import java.io.IOException;

import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionAccessorFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Importer {

    private static Logger logger = LoggerFactory.getLogger(Importer.class);

    @Autowired
    private QuestionnairDefinitionAccessorFacade questionnairDefinitionAccessorFacade;

    public void doImport() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/examples/QuestionnairDefinition_12.xml");
            QuestionnairDefinitionDTO imported = questionnairDefinitionAccessorFacade.importQuestionnairDefinition(fis);
            logger.info("Questionnair Definition imported with id = {}", imported.getId());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

}

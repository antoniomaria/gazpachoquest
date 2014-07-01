package net.sf.gazpachoquest.facades.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.sf.gazpachoquest.facades.QuestionnairDefinitionExporterFacade;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairDefinitionExporterFacadeImpl implements QuestionnairDefinitionExporterFacade {

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Override
    public void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream) throws XmlMappingException,
            IOException {
        questionnairDefinitionService.exportQuestionnairDefinition(questionnairDefinitionId, outputStream);
    }

    @Override
    public void importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException, IOException {
        questionnairDefinitionService.importQuestionnairDefinition(inputStream);
    }
}

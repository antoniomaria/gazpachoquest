package net.sf.gazpachoquest.facades;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.oxm.XmlMappingException;

public interface QuestionnairDefinitionExporterFacade {

    void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream) throws XmlMappingException, IOException;

    void importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException, IOException;
}

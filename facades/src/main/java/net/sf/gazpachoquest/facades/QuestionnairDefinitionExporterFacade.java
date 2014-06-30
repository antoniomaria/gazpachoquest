package net.sf.gazpachoquest.facades;

import java.io.OutputStream;

public interface QuestionnairDefinitionExporterFacade {

    void export(Integer questionnairDefinition, OutputStream outputStream);
}

package net.sf.gazpachoquest.facades.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.stream.StreamResult;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionExporterFacade;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairDefinitionExporterFacadeImpl implements QuestionnairDefinitionExporterFacade {

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Mapper mapper;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Override
    public void export(Integer questionnairDefinitionId, OutputStream outputStream) {
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionService.findOne(questionnairDefinitionId);
        QuestionnairDefinitionDTO dto = mapper.map(questionnairDefinition, QuestionnairDefinitionDTO.class,
                "toDTOwithQuestionGroups");

        try {
            marshaller.marshal(dto, new StreamResult(outputStream));
        } catch (XmlMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

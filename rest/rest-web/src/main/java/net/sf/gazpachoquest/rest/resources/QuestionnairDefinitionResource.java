package net.sf.gazpachoquest.rest.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionAccessorFacade;

import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/questionnair-definitions")
@Api(value = "questionnair-definitions", description = "Questionnair Definition Interface")
public class QuestionnairDefinitionResource {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairDefinitionResource.class);

    @Autowired
    private QuestionnairDefinitionAccessorFacade questionnairDefinitionAccessorFacade;

    @POST
    @Path("/import")
    @Consumes("multipart/form-data")
    @ApiOperation(value = "Import questionnair definition", notes = "Only xml format supported", response = QuestionnairDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 415, message = "Unsupported format"),
            @ApiResponse(code = 200, message = "Imported questionnair definition") })
    @ApiImplicitParams(@ApiImplicitParam(dataType = "file", name = "content", paramType = "body"))
    @Produces(MediaType.APPLICATION_JSON)
    public QuestionnairDefinitionDTO importQuestionnairDefinition(@Multipart(value = "content", type = "text/xml")
    @ApiParam(access = "internal")
    InputStream content) throws Exception {
        logger.info("New import QuestionnairDefinition petition received");
        QuestionnairDefinitionDTO imported = questionnairDefinitionAccessorFacade.importQuestionnairDefinition(content);
        logger.info("QuestionnairDefinition imported with id = {}", imported.getId());
        return imported;
    }

    @GET
    @Path("/{questionnairDefinitionId}/export")
    @ApiOperation(value = "Export given questionnair definition into xml", response = QuestionnairDefinitionDTO.class, produces = "application/xml")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Not enough access rights"),
            @ApiResponse(code = 200, message = "Questionnair Definition available") })
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public InputStream exportQuestionnairDefinition(@PathParam("questionnairDefinitionId")
    @ApiParam(value = "Questionnair DefinitionId id")
    Integer questionnairDefinitionId) throws XmlMappingException, IOException {
        logger.info("New exporting petition received for  QuestionnairDefinitionId {}", questionnairDefinitionId);

        CachedOutputStream outputStream = new CachedOutputStream();
        questionnairDefinitionAccessorFacade.exportQuestionnairDefinition(questionnairDefinitionId, outputStream);
        logger.info("QuestionnairDefinition with id = {} exported succesfully", questionnairDefinitionId);
        return outputStream.getInputStream();
    }
}

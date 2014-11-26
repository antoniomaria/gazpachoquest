package net.sf.gazpachoquest.rest.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionAccessorFacade;

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

@Path("/questionnaire-definitions")
@Api(value = "questionnaire-definitions", description = "Questionnaire Definition Interface")
public class QuestionnaireDefinitionResource {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireDefinitionResource.class);

    @Autowired
    private QuestionnaireDefinitionAccessorFacade questionnaireDefinitionAccessorFacade;

    @GET
    @ApiOperation(value = "Returns questionnaire definitions available", response = PageDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Not enough access rights"),
            @ApiResponse(code = 200, message = "Questionnaire Definitions available") })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PageDTO<QuestionnaireDefinitionDTO> getQuestionnaireDefinitions(
            @NotNull @ApiParam(name = "pageNumber", value = "Refers page number", required = true) @QueryParam("pageNumber") Integer pageNumber,
            @NotNull @ApiParam(name = "size", value = "Refers page size", required = true) @QueryParam("size") Integer size)
            throws XmlMappingException, IOException {
        logger.info("New getQuestionnairDefinitions petition received ");
        return questionnaireDefinitionAccessorFacade.findPaginated(pageNumber, size);
    }

    @POST
    @Path("/import")
    @Consumes("multipart/form-data")
    @ApiOperation(value = "Import questionnaire definition", notes = "Only xml format supported", response = QuestionnaireDefinitionDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 415, message = "Unsupported format"),
            @ApiResponse(code = 200, message = "Imported questionnaire definition") })
    @ApiImplicitParams(@ApiImplicitParam(dataType = "file", name = "content", paramType = "body"))
    @Produces(MediaType.APPLICATION_JSON)
    public QuestionnaireDefinitionDTO importQuestionnairDefinition(
            @Multipart(value = "content", type = "text/xml") @ApiParam(access = "internal") InputStream content)
            throws Exception {
        logger.info("New import QuestionnaireDefinition petition received");
        QuestionnaireDefinitionDTO imported = questionnaireDefinitionAccessorFacade
                .importQuestionnaireDefinition(content);
        logger.info("QuestionnaireDefinition imported with id = {}", imported.getId());
        return imported;
    }

    @GET
    @Path("/{questionnaireDefinitionId}/export")
    @ApiOperation(value = "Export given questionnaire definition into xml", response = QuestionnaireDefinitionDTO.class, produces = "application/xml")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Not enough access rights"),
            @ApiResponse(code = 200, message = "Questionnaire Definition available") })
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public InputStream exportQuestionnairDefinition(
            @NotNull @PathParam("questionnaireDefinitionId") @ApiParam(value = "Questionnaire DefinitionId id", required = true) Integer questionnairDefinitionId)
            throws XmlMappingException, IOException {
        logger.info("New exporting petition received for  QuestionnairDefinitionId {}", questionnairDefinitionId);

        CachedOutputStream outputStream = new CachedOutputStream();
        questionnaireDefinitionAccessorFacade.exportQuestionnaireDefinition(questionnairDefinitionId, outputStream);
        logger.info("QuestionnaireDefinition with id = {} exported succesfully", questionnairDefinitionId);
        return outputStream.getInputStream();
    }

}

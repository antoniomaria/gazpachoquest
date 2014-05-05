package net.sf.gazpachoquest.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/questionnairs")
@Api(value = "questionnairs", description = "Questionnairs Interface")
@Provider
@Produces(MediaType.APPLICATION_JSON)
// https://github.com/jurberg/rest-security/
// http://www.thebuzzmedia.com/designing-a-secure-rest-api-without-oauth-authentication/
// http://gary-rowe.com/agilestack/2012/10/23/multibit-merchant-implementing-hmac-authentication-in-dropwizard/
// http://www.thebuzzmedia.com/designing-a-secure-rest-api-without-oauth-authentication/
public class QuestionnairResource {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairResource.class);

    @Autowired
    private QuestionnairFacade questionnairFacade;

    public QuestionnairResource() {
        super();
    }

    @GET
    @Path("/{questionnairId}")
    @ApiOperation(value = "Get questionnair definition", notes = "More notes about this method", response = QuestionnairDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Questionnairs available") })
    public Response getDefinition(@PathParam("questionnairId")
    @ApiParam(value = "Questionnair id")
    Integer questionnairId) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnair:read:" + questionnairId);
        logger.debug("Fetching Questionnair Definition {} for user {}", questionnairId, principal.getFullName());
        QuestionnairDTO questionnairDTO = questionnairFacade.findOne(questionnairId);
        return Response.ok(questionnairDTO).build();
    }

    @GET
    @Path("/{questionnairId}/page")
    @ApiOperation(value = "Fetch the next, current or previous page for the given questionnair", notes = "More notes about this method", response = PageDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Questionnairs available") })
    public Response getPage(

            @PathParam("questionnairId")
            @ApiParam(value = "Questionnair id")
            Integer questionnairId,
            @ApiParam(name = "mode", value = "Refers how many questions are returned by page.", required = true, defaultValue = "GROUP_BY_GROUP", allowableValues = "QUESTION_BY_QUESTION,GROUP_BY_GROUP", allowMultiple = true)
            @QueryParam("mode")
            String modeStr,
            @ApiParam(name = "action", value = "Action fired for the respondent", required = true, defaultValue = "ENTERING", allowableValues = "FORWARD,BACKWARD,ENTERING", allowMultiple = true)
            @QueryParam("action")
            String actionStr) {

        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnair:read:" + questionnairId);
        logger.debug("Fetching questionnairId {} page {} for {} user {}", questionnairId, actionStr,
                principal.getFullName());

        RenderingMode mode = RenderingMode.fromString(modeStr);
        BrowsingAction action = BrowsingAction.fromString(actionStr);
        PageDTO page = questionnairFacade.resolvePage(questionnairId, mode, action);
        return Response.ok(page).build();
    }

    @POST
    @Path("/{questionnairId}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Allow the respondent save answers")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Answer saved correctly") })
    public Response saveAnswer(@ApiParam(value = "Answer", required = true)
    Answer answer, @PathParam("questionnairId")
    @ApiParam(value = "Questionnair id", required = true)
    Integer questionnairId, @QueryParam("questionCode")
    @ApiParam(value = "Question Code", required = true)
    String questionCode) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnair:update:" + questionnairId);

        logger.debug("User {} saving answers for questionnairId {}", principal.getFullName(), questionnairId);
        questionnairFacade.saveAnswer(questionnairId, questionCode, answer);
        return Response.ok().build();
    }
}

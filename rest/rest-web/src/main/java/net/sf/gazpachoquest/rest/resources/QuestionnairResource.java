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

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.QuestionnairPageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
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
@Produces(MediaType.APPLICATION_JSON)
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
    @ApiOperation(value = "Fetch the next, current or previous page for the given questionnair", notes = "More notes about this method", response = QuestionnairPageDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Questionnairs available") })
    public Response getPage(

            @PathParam("questionnairId")
            @ApiParam(value = "Questionnair id")
            Integer questionnairId,
            @ApiParam(name = "mode", value = "Refers how many questions are returned by page.", required = true, defaultValue = "GROUP_BY_GROUP", allowableValues = "QUESTION_BY_QUESTION,GROUP_BY_GROUP,ALL_IN_ONE", allowMultiple = true)
            @QueryParam("mode")
            String modeStr,
            @ApiParam(name = "preferredLanguage", value = "Preferred Language for the page is availabe", required = true, defaultValue = "EN", allowableValues = "EN,ES,FI", allowMultiple = true)
            @QueryParam("preferredLanguage")
            String preferredLanguageStr,
            @ApiParam(name = "action", value = "Action fired for the respondent", required = true, defaultValue = "ENTERING", allowableValues = "NEXT,PREVIOUS,ENTERING", allowMultiple = true)
            @QueryParam("action")
            String actionStr) {

        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnair:read:" + questionnairId);
        logger.debug("Fetching questionnairId {} page {} for {} user {}", questionnairId, actionStr,
                principal.getFullName());

        RenderingMode mode = RenderingMode.fromString(modeStr);
        NavigationAction action = NavigationAction.fromString(actionStr);
        Language preferredLanguage = Language.fromString(preferredLanguageStr);
        QuestionnairPageDTO page = questionnairFacade.resolvePage(questionnairId, mode, preferredLanguage, action);
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

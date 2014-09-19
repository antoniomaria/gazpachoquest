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
import net.sf.gazpachoquest.dto.QuestionnaireDTO;
import net.sf.gazpachoquest.dto.QuestionnairePageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.facades.QuestionnaireFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.commons.lang.StringUtils;
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

@Path("/questionnaires")
@Api(value = "questionnaires", description = "questionnaires Interface")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionnaireResource {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireResource.class);

    @Autowired
    private QuestionnaireFacade questionnaireFacade;

    public QuestionnaireResource() {
        super();
    }

    @GET
    @Path("/{questionnaireId}")
    @ApiOperation(value = "Get questionnaire definition", notes = "More notes about this method", response = QuestionnaireDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "questionnaires available") })
    public Response getDefinition(@PathParam("questionnaireId")
    @ApiParam(value = "Questionnaire id")
    Integer questionnaireId) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnaire:read:" + questionnaireId);
        logger.debug("Fetching Questionnaire Definition {} for user {}", questionnaireId, principal.getFullName());
        QuestionnaireDTO questionnaireDTO = questionnaireFacade.findOne(questionnaireId);
        return Response.ok(questionnaireDTO).build();
    }

    @GET
    @Path("/{questionnaireId}/page")
    @ApiOperation(value = "Fetch the next, current or previous page for the given questionnaire", notes = "More notes about this method", response = QuestionnairePageDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "questionnaires available") })
    public Response getPage(

            @PathParam("questionnaireId")
            @ApiParam(value = "Questionnaire id")
            Integer questionnaireId,
            @ApiParam(name = "mode", value = "Refers how many questions are returned by page.", required = false, defaultValue = "SECTION_BY_SECTION", allowableValues = "QUESTION_BY_QUESTION,SECTION_BY_SECTION,ALL_IN_ONE", allowMultiple = true)
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
        subject.checkPermission("questionnaire:read:" + questionnaireId);
        logger.info("Fetching questionnaire {} for {} user {}", questionnaireId, principal.getFullName());
        RenderingMode mode = StringUtils.isNotBlank(modeStr) ? RenderingMode.fromValue(modeStr) : null;
        NavigationAction action = NavigationAction.fromString(actionStr);
        Language preferredLanguage = Language.fromString(preferredLanguageStr);
        QuestionnairePageDTO page = questionnaireFacade.resolvePage(questionnaireId, mode, preferredLanguage, action);
        return Response.ok(page).build();
    }

    @POST
    @Path("/{questionnaireId}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Allow the respondent save answers")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Answer saved correctly") })
    public Response saveAnswer(@ApiParam(value = "Answer", required = true)
    Answer answer, @PathParam("questionnaireId")
    @ApiParam(value = "Questionnaire id", required = true)
    Integer questionnaireId, @QueryParam("questionCode")
    @ApiParam(value = "Question Code", required = true)
    String questionCode) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        subject.checkPermission("questionnaire:update:" + questionnaireId);

        logger.debug("User {} saving answers for questionnaireId {}", principal.getFullName(), questionnaireId);
        questionnaireFacade.saveAnswer(questionnaireId, questionCode, answer);
        return Response.ok().build();
    }
}

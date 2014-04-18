package net.sf.gazpachoquest.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.shiro.SecurityUtils;
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

	private static final Logger logger = LoggerFactory
			.getLogger(QuestionnairResource.class);

	@Autowired
	private QuestionnairFacade questionnairFacade;

	public QuestionnairResource() {
		super();
	}

	@GET
	@Path("/{questionnairId}")
	@ApiOperation(value = "Get questionnair definition", notes = "More notes about this method", response = QuestionnairDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid invitation token supplied"),
			@ApiResponse(code = 200, message = "Questionnairs available") })
	public Response getDefinition(
			@PathParam("questionnairId") @ApiParam(value = "Questionnair id") Integer questionnairId) {
		SecurityUtils.getSubject().checkPermission(
				"questionnair:read:" + questionnairId);
		logger.debug("Fetching Questionnair Definition {}", questionnairId);
		QuestionnairDTO questionnairDTO = questionnairFacade
				.findOne(questionnairId);
		return Response.ok(questionnairDTO).build();
	}

	@GET
	@Path("/{questionnairId}/page")
	// @RolesAllowed("respondent")
	@ApiOperation(value = "Fetch the next, current or previous page for the given questionnair", notes = "More notes about this method", response = PageDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid invitation token supplied"),
			@ApiResponse(code = 200, message = "Questionnairs available") })
	public Response getPage(
			@Context final SecurityContext context,
			@PathParam("questionnairId") @ApiParam(value = "Questionnair id") Integer questionnairId,
			@ApiParam(name = "mode", value = "Refers how many questions are returned by page.", required = true, defaultValue = "GROUP_BY_GROUP", allowableValues = "QUESTION_BY_QUESTION,GROUP_BY_GROUP", allowMultiple = true) @QueryParam("mode") String modeStr,
			@ApiParam(name = "action", value = "Action fired for the respondent", required = true, defaultValue = "ENTERING", allowableValues = "FORWARD,BACKWARD,ENTERING", allowMultiple = true) @QueryParam("action") String actionStr) {
		logger.debug("New petition received from {}", context
				.getUserPrincipal().getName());
		RenderingMode mode = RenderingMode.fromString(modeStr);
		BrowsingAction action = BrowsingAction.fromString(actionStr);
		PageDTO page = questionnairFacade.resolvePage(questionnairId, mode,
				action);
		return Response.ok(page).build();
	}

	@POST
	@Path("/{questionnairId}/answer")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Allow the respondent save answers")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid invitation token supplied"),
			@ApiResponse(code = 200, message = "Answer saved correctly") })
	public Response saveAnswer(
			@ApiParam(value = "Answer", required = true) Answer answer,
			@Context final SecurityContext context,
			@PathParam("questionnairId") @ApiParam(value = "Questionnair id", required = true) Integer questionnairId,
			@QueryParam("questionCode") @ApiParam(value = "Question Code", required = true) String questionCode) {
		logger.debug("New attempt for saving answer from {}", context
				.getUserPrincipal().getName());
		try {
			questionnairFacade.saveAnswer(questionnairId, questionCode, answer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok().build();
	}
}

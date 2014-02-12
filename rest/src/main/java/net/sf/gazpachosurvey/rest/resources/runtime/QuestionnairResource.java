package net.sf.gazpachosurvey.rest.resources.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDTO;
import net.sf.gazpachosurvey.dto.answers.Answer;
import net.sf.gazpachosurvey.facades.QuestionnairFacade;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("runtime/questionnairs")
@Provider
public class QuestionnairResource {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairResource.class);

    @Autowired
    private QuestionnairFacade questionnairFacade;

    public QuestionnairResource() {
        super();
    }

    @GET
    @RolesAllowed("respondent")
    @Produces({ "application/json", MediaType.APPLICATION_JSON })
    public Response list(@Context
    final SecurityContext context) {
        logger.debug("New petition received from {}", context.getUserPrincipal().getName());
        Participant respondent = (Participant) context.getUserPrincipal();

        Set<Questionnair> questionnairs = respondent.getQuestionnairs();
        List<QuestionnairDTO> questionnairDTOs = new ArrayList<QuestionnairDTO>();

        for (Questionnair questionnair : questionnairs) {
            QuestionnairDTO questionnairDTO = questionnairFacade.findOne(questionnair.getId());
            questionnairDTOs.add(questionnairDTO);
        }
        logger.debug("Respondent {} retriving Questionnair list for participantId = {}", respondent.getId());
        return Response.ok(questionnairDTOs).build();
    }

    @GET
    @Path("/{questionnairId}")
    @RolesAllowed("respondent")
    @Produces({ "application/json", MediaType.APPLICATION_JSON })
    public Response resolvePage(@Context
    final SecurityContext context, @PathParam("questionnairId")
    Integer questionnairId, @QueryParam("mode")
    RenderingMode mode, @QueryParam("action")
    BrowsingAction action) {
        logger.debug("New petition received from {}", context.getUserPrincipal().getName());
        PageDTO page = questionnairFacade.resolvePage(questionnairId, mode, action);
        return Response.ok(page).build();
    }

    @POST
    @Path("/{questionnairId}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ "application/json", MediaType.APPLICATION_JSON })
    public Response saveAnswer(Answer answer, @Context
    final SecurityContext context, @PathParam("questionnairId")
    Integer questionnairId, @QueryParam("questionCode")
    String questionCode) {
        logger.debug("New petition received from {}", context.getUserPrincipal().getName());
        questionnairFacade.saveAnswer(questionnairId, questionCode, answer);
        return Response.ok().build();
    }
}

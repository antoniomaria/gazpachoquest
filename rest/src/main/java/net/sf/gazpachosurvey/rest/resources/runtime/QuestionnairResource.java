package net.sf.gazpachosurvey.rest.resources.runtime;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("questionnair")
public class QuestionnairResource {

    private static final Logger logger = LoggerFactory
            .getLogger(QuestionnairResource.class);

    public QuestionnairResource() {
    }

    /*
     * @GET
     * 
     * @Produces(MediaType.APPLICATION_JSON) public List<SurveyDTO> getSurveys()
     * { return surveyService.findAll(); }
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("respondent")
    public Response getHello(@Context
    SecurityContext context) {
        logger.debug("New petition received from {}", context
                .getUserPrincipal().getName());
        String response = String.format("%s", "hola holitas!");
        return Response.ok(response).build();
    }

}

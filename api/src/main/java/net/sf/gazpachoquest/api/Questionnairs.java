package net.sf.gazpachoquest.api;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

@Path("/api/runtime/questionnairs")
@Produces(MediaType.APPLICATION_JSON)
public interface Questionnairs extends Serializable {

    @GET
    List<QuestionnairDTO> list();

    @GET
    @Path("/{questionnairId}/page")
    PageDTO getPage(@PathParam("questionnairId")
    Integer questionnairId, @QueryParam("mode")
    RenderingMode mode, @QueryParam("action")
    BrowsingAction action);

}

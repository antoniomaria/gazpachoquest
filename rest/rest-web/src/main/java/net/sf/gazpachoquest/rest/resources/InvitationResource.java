package net.sf.gazpachoquest.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.InvitationDTO;
import net.sf.gazpachoquest.dto.PersonalInvitationDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.facades.InvitationFacade;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "/invitations", description = "Invitations Interface")
@Produces(MediaType.APPLICATION_JSON)
@Path("/invitations")
public class InvitationResource {

    private static final Logger logger = LoggerFactory.getLogger(InvitationResource.class);

    @Autowired
    private InvitationFacade invitationFacade;

    public InvitationResource() {
        super();
    }

    @GET
    @Path("/")
    @ApiOperation(value = "Get invitation list", notes = "More notes about this method", response = InvitationDTO.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Researches available") })
    public List<InvitationDTO> getInvitations(
            @ApiParam(name = "respondentId", value = "Refers page respondentId", required = false) @QueryParam("respondentId") Integer respondentId,
            @ApiParam(name = "researchId", value = "Refers researchId", required = false) @QueryParam("researchId") Integer researchId) {
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        logger.debug("{} fetching existing invitations", principal.getFullName());

        InvitationDTO invitationDTO = null;
        if (respondentId != null) {
            invitationDTO = new PersonalInvitationDTO();
            ((PersonalInvitationDTO) invitationDTO).setRespondent(UserDTO.with().id(respondentId).build());
        } else {
            invitationDTO = new InvitationDTO();
        }
        if (researchId != null){
            invitationDTO.setResearch(ResearchDTO.with().id(researchId).build());
        }
        return invitationFacade.findByExample(invitationDTO);
    }

}

package net.sf.gazpachoquest.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;
import net.sf.gazpachoquest.facades.UserFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/users")
@Api(value = "users", description = "Users Interface")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserFacade userFacade;

    public UserResource() {
        super();
    }

    // http://www.baeldung.com/2012/01/18/rest-pagination-in-spring/
    // http://java.dzone.com/articles/rest-pagination-spring
    @GET
    @ApiOperation(value = "Get user list", notes = "More notes about this method", response = PageDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid invitation token supplied"),
            @ApiResponse(code = 200, message = "Users available") })
    public PageDTO<UserDTO> findPaginated(@ApiParam(name = "pageNumber", value = "Refers page number", required = true)
    @QueryParam("pageNumber")
    Integer pageNumber, @ApiParam(name = "size", value = "Refers page size", required = true)
    @QueryParam("size")
    Integer size) {
        logger.debug("Fetching all users");
        return userFacade.findPaginated(pageNumber, size);
    }

}

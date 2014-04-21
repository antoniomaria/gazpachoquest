package net.sf.gazpachoquest.api;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.auth.Account;


@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public interface AuthenticationResource extends Serializable{

	@GET
	@Path("/respondent")
	Account authenticate(@QueryParam("username") String username,
			@QueryParam("password") String password);
	

}

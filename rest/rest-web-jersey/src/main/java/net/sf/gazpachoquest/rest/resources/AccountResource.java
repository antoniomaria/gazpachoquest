package net.sf.gazpachoquest.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachoquest.dto.auth.Account;

import com.wordnik.swagger.annotations.Api;

@Path("/account")
@Api(value = "/account", description = "Runtime Questionnairs Interface")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @GET
    public Account find(@PathParam("username")
    String username, @PathParam("password")
    String password) {

        return null;
    }
}

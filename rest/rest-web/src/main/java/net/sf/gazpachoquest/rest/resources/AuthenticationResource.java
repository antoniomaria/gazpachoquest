package net.sf.gazpachoquest.rest.resources;

import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachoquest.dto.auth.AbstractAccount;
import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.security.AccountType;
import net.sf.gazpachoquest.security.AuthenticationManager;
import net.sf.gazpachoquest.security.AuthenticationManagerFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/auth")
@Api(value = "/auth", description = "Authentication Interface")
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class AuthenticationResource {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);

    @Autowired
    private AuthenticationManagerFactory authenticationManagerFactory;

    @GET
    @ApiOperation(value = "Authentication for users", response = AbstractAccount.class)
    public Response authenticate(@QueryParam("username")
    @ApiParam(value = "User name")
    String username, @QueryParam("password")
    @ApiParam(value = "User name")
    String password) throws AccountNotFoundException {
        logger.info("New authentication petition received");
        AuthenticationManager authManager = null;
        if (StringUtils.isBlank(username)) {
            throw new AccountNotFoundException("Username is required");
        }
        if (RespondentAccount.USER_NAME.equals(username)) {
            authManager = authenticationManagerFactory.getObject(AccountType.RESPONDENT);
        } else {
            throw new AccountNotFoundException("Wrong credentials");
        }

        Account account = authManager.authenticate(username, password);
        return Response.ok(account).build();
    }
}

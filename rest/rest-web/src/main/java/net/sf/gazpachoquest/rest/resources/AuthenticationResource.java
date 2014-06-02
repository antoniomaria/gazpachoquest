package net.sf.gazpachoquest.rest.resources;

import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
public class AuthenticationResource {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);

    @Autowired
    private AuthenticationManagerFactory authenticationManagerFactory;

    @GET
    @ApiOperation(value = "Authentication for respondents", response = AbstractAccount.class)
    public Response authenticate(@QueryParam("invitation")
    @ApiParam(value = "Invitation token")
    String invitation) throws AccountNotFoundException {
        logger.info("New respondent authentication petition received");

        if (StringUtils.isBlank(invitation)) {
            throw new AccountNotFoundException("Invitation token is required");
        }

        AuthenticationManager authManager = authenticationManagerFactory.getObject(AccountType.RESPONDENT);

        Account account = authManager.authenticate(RespondentAccount.USER_NAME, invitation);
        return Response.ok(account).build();
    }
}

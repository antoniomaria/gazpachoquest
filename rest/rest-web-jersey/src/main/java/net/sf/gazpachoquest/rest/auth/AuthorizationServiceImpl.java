package net.sf.gazpachoquest.rest.auth;

import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.security.LoginManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    @Autowired
    private LoginManager loginManager;

    @Override
    public SecurityContext authorize(final AuthorizationRequestContext authRequestContext) {

        String[] userAndPassword = BasicAuthHelper.decode(authRequestContext.getAuthorizationToken());
        if (userAndPassword == null || userAndPassword.length != 2) {
            logger.error("Bad credentials: {}", authRequestContext.getAuthorizationToken());
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        String userName = userAndPassword[0];
        String password = userAndPassword[1];

        String apiKey = null;
        Account account = null;
        try {
            account = loginManager.login(apiKey);
        } catch (AccountNotFoundException e) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return SecurityContextImpl.with().principal(account).roles(account.getRoles()).build();
    }
}

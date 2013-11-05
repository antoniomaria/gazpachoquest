package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationServiceImpl implements AuthorizationService{

    private static final Logger logger = LoggerFactory
            .getLogger(AuthorizationServiceImpl.class);

    
    public SecurityContext authorize(
            AuthorizationRequestContext authRequestContext) {
        // login and password
        String[] lap = BasicAuthHelper.decode(authRequestContext
                .getAuthorizationToken());
        if (lap == null || lap.length != 2) {
            logger.error("Bad credentials: {}",
                    authRequestContext.getAuthorizationToken());
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        String userName = lap[0];
        String password = lap[1];
        
        SecurityContextImpl securityContext = SecurityContextImpl.with()
                .userName(lap[0]).role(lap[1]).build();
        securityContext.addRole("respondent");
        return securityContext;
    }

}

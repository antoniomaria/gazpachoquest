package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import net.sf.gazpachosurvey.domain.support.Person;
import net.sf.gazpachosurvey.security.LoginService;
import net.sf.gazpachosurvey.security.LoginServiceFactory;
import net.sf.gazpachosurvey.security.LoginServiceType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthorizationServiceImpl.class);

    @Autowired
    private LoginServiceFactory loginServiceFactory;

    public SecurityContext authorize(
            AuthorizationRequestContext authRequestContext) {
        String[] userAndPassword = BasicAuthHelper.decode(authRequestContext
                .getAuthorizationToken());
        if (userAndPassword == null || userAndPassword.length != 2) {
            logger.error("Bad credentials: {}",
                    authRequestContext.getAuthorizationToken());
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        String userName = userAndPassword[0];
        String password = userAndPassword[1];

        LoginService loginService = selectLoginService(userName);

        Person person = loginService.login(userName, password);

        if (person == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return SecurityContextImpl.from(person);
    }

    private LoginService selectLoginService(String userName) {
        LoginService loginService = null;

        if (LoginService.RESPONDENT_USER_NAME.equals(userName)) {
            loginService = loginServiceFactory
                    .getObject(LoginServiceType.RESPONDENT);
        }
        return loginService;
    }

}

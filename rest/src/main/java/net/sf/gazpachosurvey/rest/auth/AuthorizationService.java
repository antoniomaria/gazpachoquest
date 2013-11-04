package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.core.SecurityContext;

public interface AuthorizationService {

    SecurityContext authorize(AuthorizationRequestContext authRequestContext);
}

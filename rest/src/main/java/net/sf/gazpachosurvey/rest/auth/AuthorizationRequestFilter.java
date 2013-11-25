package net.sf.gazpachosurvey.rest.auth;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

// http://anismiles.wordpress.com/2012/03/02/securing-versioning-and-auditing-rest-jax-rs-jersey-apis/
@Priority(value = 1000)
@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        String requestUrl = requestContext.getUriInfo().getPath();

        // We do allow wadl to be retrieve
        if (method.equals("GET")
                && (requestUrl.equals("application.wadl") || requestUrl.equals("application.wadl/xsd0.xsd"))) {
            return;
        }

        // Get the authentification passed in HTTP headers parameters
        String authToken = requestContext.getHeaderString("authorization");

        AuthorizationRequestContext authRequestContext = AuthorizationRequestContext.with().httpMethod(method)
                .requestUrl(requestUrl).authorizationToken(authToken).build();

        SecurityContext context = authorizationService.authorize(authRequestContext);
        requestContext.setSecurityContext(context);
    }

}

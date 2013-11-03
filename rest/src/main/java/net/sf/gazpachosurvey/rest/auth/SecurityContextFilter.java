package net.sf.gazpachosurvey.rest.auth;

import net.sf.gazpachosurvey.api.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// http://anismiles.wordpress.com/2012/03/02/securing-versioning-and-auditing-rest-jax-rs-jersey-apis/
//@Component
public class SecurityContextFilter {

   // private static final Logger logger = LoggerFactory            .getLogger(SecurityContextFilter.class);

    //private HttpServletResponse response;

   // @Autowired
  //  private SecurityService authorizationService;
/*
    public ContainerRequest filter(ContainerRequest request) {

        String authToken = request.getHeaderValue(HttpHeaders.AUTHORIZATION);
        logger.debug("Authorization token: {}", authToken);
        if (1 == 1)
            return request;

        boolean authenticated = authorizationService.isAuthenticated();
        if (!authenticated) {
            response.setHeader(HttpHeaders.WWW_AUTHENTICATE,
                    "Basic realm=\"Gazpacho API\"");
            try {
                response.sendError(HttpStatus.SC_UNAUTHORIZED);
            } catch (IOException e) {
                throw new WebApplicationException(HttpStatus.SC_UNAUTHORIZED);
            }

        } else {
            String username = authorizationService.currentUsername();
        }
        return request;
    }
    public ContainerRequestFilter getRequestFilter() {
        return this;
    }

    public ContainerResponseFilter getResponseFilter() {
        return null;
    }
*/

}

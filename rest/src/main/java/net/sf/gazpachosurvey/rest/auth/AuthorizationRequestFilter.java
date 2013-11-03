package net.sf.gazpachosurvey.rest.auth;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// http://anismiles.wordpress.com/2012/03/02/securing-versioning-and-auditing-rest-jax-rs-jersey-apis/
//@Component
@Priority(value = 1)
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LoggerFactory
            .getLogger(LoginService.class);

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        logger.info("Accesing to {}", path);

        // Get the authentification passed in HTTP headers parameters
        String auth = requestContext.getHeaderString("authorization");

        // If the user does not have the right (does not provide any HTTP Basic
        // Auth)
        if (auth == null) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }

        System.out
                .println("AuthorizationRequestFilter ?? llamado!!! : " + auth);

        // We do allow wadl to be retrieve
        if (method.equals("GET")
                && (path.equals("application.wadl") || path
                        .equals("application.wadl/xsd0.xsd"))) {
            return;
        }
        // lap : loginAndPassword
        String[] lap = decode(auth);
        SecurityContext context = SecurityContextImpl.with().userName("anonimous").role("respondent").build();
        requestContext.setSecurityContext(context);
    }

    public static String[] decode(String auth) {
        // Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
        auth = auth.replaceFirst("[B|b]asic ", "");

        // Decode the Base64 into byte[]
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

        // If the decode fails in any case
        if (decodedBytes == null || decodedBytes.length == 0) {
            return null;
        }

        // Now we can convert the byte[] into a splitted array :
        // - the first one is login,
        // - the second one password
        return new String(decodedBytes).split(":", 2);
    }

    // private static final Logger logger = LoggerFactory
    // .getLogger(AuthorizationRequestFilter.class);

    // private HttpServletResponse response;

    // @Autowired
    // private SecurityService authorizationService;
    /*
     * public ContainerRequest filter(ContainerRequest request) {
     * 
     * String authToken = request.getHeaderValue(HttpHeaders.AUTHORIZATION);
     * logger.debug("Authorization token: {}", authToken); if (1 == 1) return
     * request;
     * 
     * boolean authenticated = authorizationService.isAuthenticated(); if
     * (!authenticated) { response.setHeader(HttpHeaders.WWW_AUTHENTICATE,
     * "Basic realm=\"Gazpacho API\""); try {
     * response.sendError(HttpStatus.SC_UNAUTHORIZED); } catch (IOException e) {
     * throw new WebApplicationException(HttpStatus.SC_UNAUTHORIZED); }
     * 
     * } else { String username = authorizationService.currentUsername(); }
     * return request; } public ContainerRequestFilter getRequestFilter() {
     * return this; }
     * 
     * public ContainerResponseFilter getResponseFilter() { return null; }
     */

}

package net.sf.gazpachosurvey.rest.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import net.sf.gazpachosurvey.api.SecurityService;
import net.sf.gazpachosurvey.rest.SurveysResource;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

// http://anismiles.wordpress.com/2012/03/02/securing-versioning-and-auditing-rest-jax-rs-jersey-apis/
@Component
public class AuthenticationFilter implements ContainerRequestFilter {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthenticationFilter.class);

    @Context
    private HttpServletResponse response;

    @Autowired
    private SecurityService authorizationService;

    @Override
    public ContainerRequest filter(ContainerRequest request) {
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

}

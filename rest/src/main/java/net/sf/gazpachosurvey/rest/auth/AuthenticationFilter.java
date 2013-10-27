package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.ext.Provider;

import net.sf.gazpachosurvey.rest.SurveysResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;
// http://anismiles.wordpress.com/2012/03/02/securing-versioning-and-auditing-rest-jax-rs-jersey-apis/
@Component 
@Scope( )
public class AuthenticationFilter implements ResourceFilter, ContainerRequestFilter{
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public ContainerRequest filter(ContainerRequest request) {
       logger.debug("filtering something");
        return request;
    }

    @Override
    public ContainerRequestFilter getRequestFilter() {
         return this;
    }

    @Override
    public ContainerResponseFilter getResponseFilter() {
        // TODO Auto-generated method stub
        return null;
    }

}

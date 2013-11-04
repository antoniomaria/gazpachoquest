package net.sf.gazpachosurvey.rest;

import net.sf.gazpachosurvey.rest.auth.AuthorizationRequestFilter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        register(RequestContextFilter.class);
        register(RolesAllowedDynamicFeature.class);
        register(AuthorizationRequestFilter.class);
        register(SurveysResource.class);
        
        //register(JerseyResource.class);
        //register(SpringSingletonResource.class);
        //register(SpringRequestResource.class);
        //register(CustomExceptionMapper.class);
        
        
    }
}

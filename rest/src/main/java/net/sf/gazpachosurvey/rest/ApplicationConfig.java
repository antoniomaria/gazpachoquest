package net.sf.gazpachosurvey.rest;

import java.util.HashMap;
import java.util.Map;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        register(RequestContextFilter.class);
        register(SurveysResource.class);
        
        //register(JerseyResource.class);
        //register(SpringSingletonResource.class);
        //register(SpringRequestResource.class);
        //register(CustomExceptionMapper.class);
    }
}

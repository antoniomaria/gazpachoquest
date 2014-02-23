package net.sf.gazpachoquest.rest;

import net.sf.gazpachoquest.rest.auth.AuthorizationRequestFilter;
import net.sf.gazpachoquest.rest.resources.runtime.QuestionnairResource;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(RequestContextFilter.class);
        register(RolesAllowedDynamicFeature.class);
        register(JacksonFeature.class);

        register(AuthorizationRequestFilter.class);
        register(QuestionnairResource.class);
        register(LoggingFilter.class);

        // register(JerseyResource.class);
        // register(SpringSingletonResource.class);
        // register(SpringRequestResource.class);
        // register(CustomExceptionMapper.class);

    }
}

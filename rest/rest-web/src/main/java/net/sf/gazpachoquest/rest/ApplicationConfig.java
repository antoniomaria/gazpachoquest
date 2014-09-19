package net.sf.gazpachoquest.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import net.sf.gazpachoquest.rest.exception.AccountNotFoundExceptionHandler;
import net.sf.gazpachoquest.rest.exception.DefaultExceptionHandler;
import net.sf.gazpachoquest.rest.exception.ShiroExceptionHandler;
import net.sf.gazpachoquest.rest.filter.LoginShiroFilter;
import net.sf.gazpachoquest.rest.filter.LogoutShiroFilter;
import net.sf.gazpachoquest.rest.resources.AuthenticationResource;
import net.sf.gazpachoquest.rest.resources.QuestionnaireDefinitionResource;
import net.sf.gazpachoquest.rest.resources.QuestionnaireResource;
import net.sf.gazpachoquest.rest.resources.UserResource;
import net.sf.gazpachoquest.rest.support.JacksonContextResolver;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    private String resourcePackage = "net.sf.gazpachoquest.rest";

    // https://github.com/rvullriede/swagger-core/blob/master/samples/swagger-java-sample-app-cxf/src/main/java/com/wordnik/swagger/sample/util/ApplicationConfig.java
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(AuthenticationResource.class);
        classes.add(QuestionnaireDefinitionResource.class);
        classes.add(QuestionnaireResource.class);
        classes.add(UserResource.class);

        classes.add(ApiListingResourceJSON.class);
        classes.add(ResourceListingProvider.class);
        classes.add(ApiDeclarationProvider.class);

        classes.add(JacksonContextResolver.class);
        classes.add(JacksonJsonProvider.class);

        classes.add(LoginShiroFilter.class);
        classes.add(LogoutShiroFilter.class);

        classes.add(ShiroExceptionHandler.class);
        classes.add(AccountNotFoundExceptionHandler.class);
        classes.add(DefaultExceptionHandler.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    public final String getResourcePackage() {
        return resourcePackage;
    }

    public final void setResourcePackage(final String ressourcePackage) {
        resourcePackage = ressourcePackage;
    }

}
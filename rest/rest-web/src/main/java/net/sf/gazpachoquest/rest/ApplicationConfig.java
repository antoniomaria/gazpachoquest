package net.sf.gazpachoquest.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import net.sf.gazpachoquest.rest.resources.AuthenticationResource;
import net.sf.gazpachoquest.rest.resources.QuestionnairResource;

import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    private String resourcePackage = "net.sf.gazpachoquest.rest";

    // https://github.com/rvullriede/swagger-core/blob/master/samples/swagger-java-sample-app-cxf/src/main/java/com/wordnik/swagger/sample/util/ApplicationConfig.java
    @Override
    public Set<Class<?>> getClasses() {/*-
                                       final ConfigurationBuilder config = new ConfigurationBuilder().setUrls(
                                       ClasspathHelper.forPackage(this.resourcePackage)).setScanners(new TypeAnnotationsScanner(),
                                       new SubTypesScanner());

                                       final Set<Class<?>> classes = new Reflections(config).getTypesAnnotatedWith(Api.class);
                                        */
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(QuestionnairResource.class);
        classes.add(AuthenticationResource.class);
        classes.add(ApiListingResourceJSON.class);
        classes.add(ResourceListingProvider.class);
        classes.add(ApiDeclarationProvider.class);

        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    public final String getResourcePackage() {
        return this.resourcePackage;
    }

    public final void setResourcePackage(final String ressourcePackage) {
        this.resourcePackage = ressourcePackage;
    }

}
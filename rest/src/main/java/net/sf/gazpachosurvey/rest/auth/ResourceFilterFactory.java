package net.sf.gazpachosurvey.rest.auth;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
*/
// https://github.com/jersey/jersey/blob/master/examples/helloworld-spring-webapp/src/main/webapp/WEB-INF/web.xml
@Component
@Provider
public class ResourceFilterFactory { // extends RolesAllowedResourceFilterFactory  {


    @Autowired
    private SecurityContextFilter securityContextFilter;
    
}

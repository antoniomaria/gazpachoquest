package net.sf.gazpachoquest.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class LogoutShiroFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}

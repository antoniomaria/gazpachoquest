package net.sf.gazpachoquest.questionnaires.security;

import java.io.Serializable;
import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.cdi.access.AccessControl;
import com.vaadin.server.VaadinServletService;

@Alternative
public class UserNameAccessControl extends AccessControl implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(UserNameAccessControl.class);

    @Override
    public boolean isUserSignedIn() {
        Principal principal = getCurrentRequest().getUserPrincipal();
        // return principal != null;
        return true;
    }

    @Override
    public boolean isUserInRole(String role) {
        logger.info("Checking if logged user is in role {}", role);
        // return getCurrentRequest().isUserInRole(role);
        return true;
    }

    @Override
    public String getPrincipalName() {
        Principal principal = getCurrentRequest().getUserPrincipal();
        if (principal != null) {
            return principal.getName();
        }

        return "foo";
    }

    /**
     * Logs in the user to underlying container security context using configured security domain in deployment
     * descriptor
     * 
     * @param username
     * @param password
     * @throws ServletException
     *             if login fails or current session has already been authenticated
     */
    public static void loginXX(String username, String password) throws ServletException {
        getCurrentRequest().login(username, password);
    }

    /**
     * Logs user out from current container managed security context
     * 
     * @throws ServletException
     */
    public static void logout() throws ServletException {
        getCurrentRequest().logout();
    }

    @Produces
    @RequestScoped
    public static HttpServletRequest getCurrentRequest() {
        HttpServletRequest request = VaadinServletService.getCurrentServletRequest();
        logger.info("Getting request " + request);

        return request;
    }

}

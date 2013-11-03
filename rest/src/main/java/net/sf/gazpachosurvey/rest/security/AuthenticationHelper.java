package net.sf.gazpachosurvey.rest.security;
/*
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
*/
public abstract class AuthenticationHelper {

    private AuthenticationHelper() {
    }
/*
    public static Authentication getAuthentication() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext == null) {
            return null;
        }
        Authentication authentication = securityContext.getAuthentication();
        return authentication;
    }

    public static String getRemoteAddress(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        Object details = authentication.getDetails();
        String address = null;
        if (details instanceof WebAuthenticationDetails) {
            address = ((WebAuthenticationDetails) details).getRemoteAddress();
        }
        return address;
    }
    */
}

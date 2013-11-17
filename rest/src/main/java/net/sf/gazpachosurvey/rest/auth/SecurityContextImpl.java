package net.sf.gazpachosurvey.rest.auth;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.SecurityContext;

import net.sf.gazpachosurvey.domain.support.Person;

public class SecurityContextImpl implements SecurityContext {

    private Set<String> roles;

    private Principal principal;

    public SecurityContextImpl() {
        super();
    }
    
    public SecurityContextImpl(Person person) {
        super();
        this.roles = person.getRoles();
        this.principal = person;
    }

    public Set<String> getRoles() {
        if (roles == null) {
            return new HashSet<>();
        }
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public Principal getUserPrincipal() {
        return principal;
    }

    @Override
    public boolean isUserInRole(String role) {
        return getRoles().contains(role);
    }

    @Override
    public boolean isSecure() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static SecurityContext from(Person person){
        return new SecurityContextImpl(person);
    }
    @Override
    public String toString() {
        return "SecurityContext [principal=" + principal + ", roles=" + roles
                + "]";
    }

}

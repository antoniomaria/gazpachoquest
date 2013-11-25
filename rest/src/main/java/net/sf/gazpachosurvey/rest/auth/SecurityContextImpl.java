package net.sf.gazpachosurvey.rest.auth;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.SecurityContext;

public class SecurityContextImpl implements SecurityContext {

    private Set<String> roles;

    private Principal principal;

    public SecurityContextImpl() {
        super();
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

    @Override
    public String toString() {
        return "SecurityContext [principal=" + principal + ", roles=" + roles + "]";
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Set<String> roles;
        private Principal principal;

        public Builder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public Builder principal(Principal principal) {
            this.principal = principal;
            return this;
        }

        public SecurityContextImpl build() {
            SecurityContextImpl securityContextImpl = new SecurityContextImpl();
            securityContextImpl.roles = roles;
            securityContextImpl.principal = principal;
            return securityContextImpl;
        }
    }
}

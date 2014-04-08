package net.sf.gazpachoquest.rest.auth;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.SecurityContext;

public class SecurityContextImpl implements SecurityContext {

    public static class Builder {
        private Principal principal;
        private Set<String> roles;

        public SecurityContextImpl build() {
            SecurityContextImpl securityContextImpl = new SecurityContextImpl();
            securityContextImpl.roles = roles;
            securityContextImpl.principal = principal;
            return securityContextImpl;
        }

        public Builder principal(final Principal principal) {
            this.principal = principal;
            return this;
        }

        public Builder roles(final Set<String> roles) {
            this.roles = roles;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }

    private Principal principal;

    private Set<String> roles;

    public SecurityContextImpl() {
        super();
    }

    @Override
    public String getAuthenticationScheme() {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<String> getRoles() {
        if (roles == null) {
            return new HashSet<>();
        }
        return roles;
    }

    @Override
    public Principal getUserPrincipal() {
        return principal;
    }

    @Override
    public boolean isSecure() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isUserInRole(final String role) {
        return getRoles().contains(role);
    }

    public void setRoles(final Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SecurityContext [principal=" + principal + ", roles=" + roles + "]";
    }
}

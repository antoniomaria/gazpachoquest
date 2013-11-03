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

    public void addRole(String role) {
        getRoles().add(role);
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

    private class PrincipalImpl implements Principal {
        private String name;

        public PrincipalImpl(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String userName;
        private Set<String> roles;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder role(String role) {
            getRoles().add(role);
            return this;
        }

        public Set<String> getRoles() {
            if (roles == null) {
                roles = new HashSet<>();
            }
            return roles;
        }

        public SecurityContextImpl build() {
            return new SecurityContextImpl(this);
        }
    }

    private SecurityContextImpl(Builder builder) {
        this.principal = new PrincipalImpl(builder.userName);
        this.roles = builder.roles;
    }

    @Override
    public String toString() {
        return "SecurityContext [principal=" + principal + ", roles=" + roles
                + "]";
    }

}

package net.sf.gazpachoquest.jaas.auth;

import java.io.Serializable;
import java.security.Principal;

public class RoleAccount implements Principal, Serializable{

    private static final long serialVersionUID = 8506986920871084818L;
    
    private String name;

    public RoleAccount() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public RoleAccount build() {
            RoleAccount roleAccount = new RoleAccount();
            roleAccount.name = name;
            return roleAccount;
        }
    }
}

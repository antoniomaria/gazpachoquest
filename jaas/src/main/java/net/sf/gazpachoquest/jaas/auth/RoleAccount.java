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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleAccount other = (RoleAccount) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
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

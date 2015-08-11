package net.sf.gazpachoquest.dto.auth;

import java.io.Serializable;
import java.security.Principal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@SuppressWarnings("serial")
public class RoleAccount implements Principal, Serializable {

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

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof RoleAccount) {
            return (new EqualsBuilder()).append(getName(), ((RoleAccount) other).getName()).isEquals();
        } else {
            return false;
        }
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

package net.sf.gazpachoquest.jaas.auth;

import java.util.HashSet;
import java.util.Set;


public class AbstractAccount implements Account {

    private static final long serialVersionUID = -5450572105061328309L;

    protected String givenNames;

    protected String surname;

    protected String email;

    protected String apiKey;

    protected String secret;

    protected Set<RoleAccount> roles;

    protected String preferredLanguage;

    protected AbstractAccount() {
        super();
    }

    @Override
    public String getGivenNames() {
        return givenNames;
    }

    @Override
    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Set<RoleAccount> getRoles() {
        if (roles == null) {
            roles = new HashSet<>();
        }
        return roles;
    }

    @Override
    public void setRoles(Set<RoleAccount> roles) {
        this.roles = roles;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    @Override
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String getName() {
        return givenNames;
    }

    public boolean hasPreferredLanguage() {
        return preferredLanguage != null;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((givenNames == null) ? 0 : givenNames.hashCode());
        result = prime * result + ((preferredLanguage == null) ? 0 : preferredLanguage.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((secret == null) ? 0 : secret.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
        AbstractAccount other = (AbstractAccount) obj;
        if (apiKey == null) {
            if (other.apiKey != null)
                return false;
        } else if (!apiKey.equals(other.apiKey))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (givenNames == null) {
            if (other.givenNames != null)
                return false;
        } else if (!givenNames.equals(other.givenNames))
            return false;
        if (preferredLanguage == null) {
            if (other.preferredLanguage != null)
                return false;
        } else if (!preferredLanguage.equals(other.preferredLanguage))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (secret == null) {
            if (other.secret != null)
                return false;
        } else if (!secret.equals(other.secret))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    @Override
    public String getFullName() {
        return new StringBuilder().append(givenNames).append(" ").append(surname).toString();
    }

    @Override
    public String toString() {
        return "AbstractAccount [givenNames=" + givenNames + ", surname=" + surname + ", email=" + email + ", apiKey="
                + apiKey + ", secret=" + secret + ", roles=" + roles + ", preferredLanguage=" + preferredLanguage + "]";
    }
    
    

}

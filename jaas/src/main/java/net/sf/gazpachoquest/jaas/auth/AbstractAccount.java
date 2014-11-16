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
    public String getFullName() {
        return new StringBuilder().append(givenNames).append(" ").append(surname).toString();
    }

    @Override
    public String toString() {
        return "AbstractAccount [givenNames=" + givenNames + ", surname=" + surname + ", email=" + email + ", apiKey="
                + apiKey + ", secret=" + secret + ", roles=" + roles + ", preferredLanguage=" + preferredLanguage + "]";
    }
    
    

}

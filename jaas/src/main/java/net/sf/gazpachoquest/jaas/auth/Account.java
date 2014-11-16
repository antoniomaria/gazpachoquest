package net.sf.gazpachoquest.jaas.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Set;

public interface Account extends Principal, Serializable {

    String getGivenNames();

    void setGivenNames(String givenNames);

    String getSurname();

    void setSurname(String surname);

    String getEmail();

    void setEmail(String email);

    String getApiKey();

    void setApiKey(String apiKey);

    Set<RoleAccount> getRoles();

    void setRoles(Set<RoleAccount> roles);

    @Override
    String getName();

    String getFullName();

    String getSecret();

    void setSecret(String secret);

}

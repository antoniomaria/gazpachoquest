package net.sf.gazpachoquest.dto.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Set;

import net.sf.gazpachoquest.dto.answers.TextAnswer;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = TextAnswer.class, name = "T"),
        @JsonSubTypes.Type(value = RespondentAccount.class, name = "R"), })
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
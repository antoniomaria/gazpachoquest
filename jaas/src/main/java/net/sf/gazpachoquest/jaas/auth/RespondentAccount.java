package net.sf.gazpachoquest.jaas.auth;

import java.util.HashSet;
import java.util.Set;

public class RespondentAccount extends AbstractAccount {

    public static final String USER_NAME = "respondent";

    public static final String DEFAULT_ROLE_NAME = "respondent";

    private static final long serialVersionUID = -4244027794423453379L;

    private final Set<Integer> grantedquestionnaireIds = new HashSet<>();

    public RespondentAccount() {
        super();
    }

    public Set<Integer> getGrantedquestionnaireIds() {
        return grantedquestionnaireIds;
    }

    public void grantquestionnaireId(Integer id) {
        getGrantedquestionnaireIds().add(id);
    }

    public void assingRole(String role) {
        getRoles().add(RoleAccount.with().name(role).build());
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String givenNames;
        private String surname;
        private String email;
        private String apiKey;
        private String secret;
        private String preferedLanguage;

        public Builder givenNames(String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder preferedLanguage(String preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }

        public RespondentAccount build() {
            RespondentAccount accountDTO = new RespondentAccount();
            accountDTO.givenNames = givenNames;
            accountDTO.surname = surname;
            accountDTO.email = email;
            accountDTO.apiKey = apiKey;
            accountDTO.secret = secret;
            accountDTO.preferredLanguage = preferedLanguage;
            return accountDTO;
        }
    }
}

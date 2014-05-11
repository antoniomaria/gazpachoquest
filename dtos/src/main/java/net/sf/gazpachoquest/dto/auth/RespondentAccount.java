/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto.auth;

import java.util.HashSet;
import java.util.Set;

public class RespondentAccount extends AbstractAccount {

    public static final String USER_NAME = "respondent";

    public static final String DEFAULT_ROLE_NAME = "respondent";

    private static final long serialVersionUID = -4244027794423453379L;

    private Set<Integer> grantedQuestionnairIds;

    public RespondentAccount() {
        super();
    }

    public Set<Integer> getGrantedQuestionnairIds() {
        if (grantedQuestionnairIds == null) {
            grantedQuestionnairIds = new HashSet<>();
        }
        return grantedQuestionnairIds;
    }

    public void setGrantedQuestionnairIds(Set<Integer> grantedQuestionnairIds) {
        this.grantedQuestionnairIds = grantedQuestionnairIds;
    }

    public void grantQuestionnairId(Integer id) {
        getGrantedQuestionnairIds().add(id);
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

        public RespondentAccount build() {
            RespondentAccount accountDTO = new RespondentAccount();
            accountDTO.givenNames = givenNames;
            accountDTO.surname = surname;
            accountDTO.email = email;
            accountDTO.apiKey = apiKey;
            accountDTO.secret = secret;
            return accountDTO;
        }
    }
}

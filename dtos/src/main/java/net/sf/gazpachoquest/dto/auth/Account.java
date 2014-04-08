/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto.auth;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Account implements Principal {

    protected String givenNames;

    protected String surname;

    protected String email;

    protected String apiKey;

    protected Set<String> roles;

    public Account() {
        super();
    }

    public Account(Account account) {
        this();
        this.givenNames = account.givenNames;
        this.surname = account.surname;
        this.email = account.email;
        this.apiKey = account.apiKey;
        this.roles = new HashSet<>();
        this.roles.addAll(account.getRoles());
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Set<String> getRoles() {
        if (roles == null) {
            this.roles = new HashSet<>();
        }
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public String getName() {
        return givenNames;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String givenNames;
        private String surname;
        private String email;
        private String apiKey;
        private Set<String> roles;

        public Builder givenNames(String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
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

        public Builder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.givenNames = givenNames;
            account.surname = surname;
            account.email = email;
            account.apiKey = apiKey;
            account.roles = roles;
            return account;
        }
    }
}

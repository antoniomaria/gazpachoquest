/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.support;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
@Table(name = "users")
public class User extends AbstractAuditable {

    private static final long serialVersionUID = 7209387649701141462L;

    @Column(nullable = false)
    private String givenNames;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String apiKey;

    @Enumerated(EnumType.STRING)
    private Language preferedLanguage;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_group", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") })
    private Set<Group> groups;

    public User() {
        super();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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

    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    public void setPreferedLanguage(Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static class Builder {
        private String givenNames;
        private String surname;
        private String email;
        private String apiKey;
        private Language preferedLanguage;
        private Gender gender;

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

        public Builder preferedLanguage(Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            User user = new User();
            user.givenNames = givenNames;
            user.surname = surname;
            user.email = email;
            user.apiKey = apiKey;
            user.preferedLanguage = preferedLanguage;
            user.gender = gender;
            return user;
        }
    }
}

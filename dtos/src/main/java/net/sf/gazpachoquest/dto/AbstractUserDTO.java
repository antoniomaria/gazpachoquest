/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.dto.support.UserDTO;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

public abstract class AbstractUserDTO extends AbstractIdentifiableDTO implements UserDTO {

    private static final long serialVersionUID = 7370786032611110768L;

    private String email;

    private String givenNames;

    private String surname;

    private String apiKey;

    private Language preferedLanguage;

    private Gender gender;

    public AbstractUserDTO() {
        super();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getGivenNames() {
        return givenNames;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public void setGivenNames(final String givenNames) {
        this.givenNames = givenNames;
    }

    @Override
    public void setSurname(final String surname) {
        this.surname = surname;
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
    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    @Override
    public void setPreferedLanguage(Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

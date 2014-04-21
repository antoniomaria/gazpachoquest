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

import net.sf.gazpachoquest.dto.answers.TextAnswer;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = TextAnswer.class, name = "T"),
		@JsonSubTypes.Type(value = RespondentAccount.class, name = "R"), })
public abstract class AbstractAccount implements Account {

	protected String givenNames;

	protected String surname;

	protected String email;

	protected String apiKey;

	protected Set<String> roles;

	public AbstractAccount() {
		super();
	}

	public AbstractAccount(AbstractAccount abstractAccount) {
		this();
		this.givenNames = abstractAccount.givenNames;
		this.surname = abstractAccount.surname;
		this.email = abstractAccount.email;
		this.apiKey = abstractAccount.apiKey;
		this.roles = new HashSet<>();
		this.roles.addAll(abstractAccount.getRoles());
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
	public Set<String> getRoles() {
		if (roles == null) {
			this.roles = new HashSet<>();
		}
		return roles;
	}

	@Override
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

	public String getFullName() {
		return new StringBuilder().append(givenNames).append(" ")
				.append(surname).toString();
	}

}

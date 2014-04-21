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

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
public abstract class AbstractAccount implements Account {

	private static final long serialVersionUID = -8204465435506099291L;

	protected String givenNames;

	protected String surname;

	protected String email;

	protected String apiKey;

	protected Set<RoleAccount> roles;

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
			this.roles = new HashSet<>();
		}
		return roles;
	}

	@Override
	public void setRoles(Set<RoleAccount> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	@JsonIgnore
	public String getName() {
		return givenNames;
	}

	@JsonIgnore
	public String getFullName() {
		return new StringBuilder().append(givenNames).append(" ")
				.append(surname).toString();
	}

}

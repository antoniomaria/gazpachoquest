package net.sf.gazpachoquest.dto.auth;

import java.util.Set;

public interface Account {

	public abstract String getGivenNames();

	public abstract void setGivenNames(String givenNames);

	public abstract String getSurname();

	public abstract void setSurname(String surname);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract String getApiKey();

	public abstract void setApiKey(String apiKey);

	public abstract Set<String> getRoles();

	public abstract void setRoles(Set<String> roles);

	public abstract String getName();

}
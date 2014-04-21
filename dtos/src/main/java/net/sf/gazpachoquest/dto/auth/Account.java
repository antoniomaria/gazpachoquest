package net.sf.gazpachoquest.dto.auth;

import java.security.Principal;
import java.util.Set;

public interface Account extends Principal {

	String getGivenNames();

	void setGivenNames(String givenNames);

	String getSurname();

	void setSurname(String surname);

	String getEmail();

	void setEmail(String email);

	String getApiKey();

	void setApiKey(String apiKey);

	Set<String> getRoles();

	void setRoles(Set<String> roles);

	String getName();
	
	String getFullName();

}
package net.sf.gazpachoquest.security;

import net.sf.gazpachosurvey.domain.support.Person;

public interface LoginService {
    final String RESPONDENT_USER_NAME = "respondent";

    Person login(String userName, String password);

}

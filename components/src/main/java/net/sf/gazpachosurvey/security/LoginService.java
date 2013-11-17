package net.sf.gazpachosurvey.security;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.support.Person;

public interface LoginService {
    final String RESPONDENT_USER_NAME = Respondent.USER_NAME;

    Person login(String userName, String password);

}

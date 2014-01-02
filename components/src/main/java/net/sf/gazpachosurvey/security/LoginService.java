package net.sf.gazpachosurvey.security;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.support.Person;

public interface LoginService {
    final String RESPONDENT_USER_NAME = Questionnair.USER_NAME;

    Person login(String userName, String password);

}

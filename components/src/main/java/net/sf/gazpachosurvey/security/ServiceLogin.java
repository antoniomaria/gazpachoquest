package net.sf.gazpachosurvey.security;

import net.sf.gazpachosurvey.domain.support.Person;

public interface ServiceLogin {

    Person login(String userName, String password);

}

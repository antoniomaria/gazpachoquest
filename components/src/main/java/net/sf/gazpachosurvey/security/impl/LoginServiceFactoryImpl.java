package net.sf.gazpachosurvey.security.impl;

import java.util.Map;

import net.sf.gazpachosurvey.security.LoginService;
import net.sf.gazpachosurvey.security.LoginServiceFactory;
import net.sf.gazpachosurvey.security.LoginServiceType;

public class LoginServiceFactoryImpl implements LoginServiceFactory {

    private Map<String, LoginService> implementations;

    public void setImplementations(Map<String, LoginService> loginServiceImplementations) {
        implementations = loginServiceImplementations;
    }

    @Override
    public LoginService getObject(LoginServiceType type) {
        LoginService impl = implementations.get(type.toString());
        if (impl == null) {
            throw new IllegalStateException("There is no implementation for type = " + type);
        }
        return impl;
    }

}

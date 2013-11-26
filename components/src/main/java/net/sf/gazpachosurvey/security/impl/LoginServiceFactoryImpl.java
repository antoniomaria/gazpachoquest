package net.sf.gazpachosurvey.security.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachosurvey.security.LoginService;
import net.sf.gazpachosurvey.security.LoginServiceFactory;
import net.sf.gazpachosurvey.security.LoginServiceType;

public class LoginServiceFactoryImpl implements LoginServiceFactory {

    private Map<String, LoginService> implementations;

    public Map<String, LoginService> getImplementations() {
        if (implementations == null) {
            implementations = new HashMap<String, LoginService>();
        }
        return implementations;
    }

    public void setImplementations(Map<String, LoginService> loginServiceImplementations) {
        implementations = loginServiceImplementations;
    }

    @Override
    public LoginService getObject(LoginServiceType type) {
        LoginService impl = getImplementations().get(type.toString());
        if (impl == null) {
            throw new IllegalStateException("There is no implementation for type = " + type);
        }
        return impl;
    }

}

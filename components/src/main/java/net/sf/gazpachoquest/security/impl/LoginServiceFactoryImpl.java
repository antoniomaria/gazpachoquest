package net.sf.gazpachoquest.security.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.security.LoginService;
import net.sf.gazpachoquest.security.LoginServiceFactory;
import net.sf.gazpachoquest.security.LoginServiceType;

public class LoginServiceFactoryImpl implements LoginServiceFactory {

    private Map<String, LoginService> implementations;

    public Map<String, LoginService> getImplementations() {
        if (implementations == null) {
            implementations = new HashMap<String, LoginService>();
        }
        return implementations;
    }

    @Override
    public LoginService getObject(final LoginServiceType type) {
        LoginService impl = getImplementations().get(type.toString());
        if (impl == null) {
            throw new IllegalStateException("There is no implementation for type = " + type);
        }
        return impl;
    }

    public void setImplementations(final Map<String, LoginService> loginServiceImplementations) {
        implementations = loginServiceImplementations;
    }

}

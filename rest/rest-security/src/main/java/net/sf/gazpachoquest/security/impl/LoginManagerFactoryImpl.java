package net.sf.gazpachoquest.security.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.security.LoginManager;
import net.sf.gazpachoquest.security.LoginManagerFactory;
import net.sf.gazpachoquest.security.AccountType;

public class LoginManagerFactoryImpl implements LoginManagerFactory {

    private Map<String, LoginManager> implementations;

    public Map<String, LoginManager> getImplementations() {
        if (implementations == null) {
            implementations = new HashMap<String, LoginManager>();
        }
        return implementations;
    }

    @Override
    public LoginManager getObject(final AccountType type) {
        LoginManager impl = getImplementations().get(type.toString());
        if (impl == null) {
            throw new IllegalStateException("There is no implementation for type = " + type);
        }
        return impl;
    }

    public void setImplementations(final Map<String, LoginManager> loginServiceImplementations) {
        implementations = loginServiceImplementations;
    }

}

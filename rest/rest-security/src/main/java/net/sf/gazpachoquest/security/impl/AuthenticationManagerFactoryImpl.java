package net.sf.gazpachoquest.security.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.security.AccountType;
import net.sf.gazpachoquest.security.AuthenticationManager;
import net.sf.gazpachoquest.security.AuthenticationManagerFactory;

public class AuthenticationManagerFactoryImpl implements AuthenticationManagerFactory {

    private Map<String, AuthenticationManager> implementations;

    public Map<String, AuthenticationManager> getImplementations() {
        if (implementations == null) {
            implementations = new HashMap<String, AuthenticationManager>();
        }
        return implementations;
    }

    @Override
    public AuthenticationManager getObject(final AccountType type) {
    	AuthenticationManager impl = getImplementations().get(type.toString());
        if (impl == null) {
            throw new IllegalStateException("There is no implementation for type = " + type);
        }
        return impl;
    }

    public void setImplementations(final Map<String, AuthenticationManager> loginServiceImplementations) {
        implementations = loginServiceImplementations;
    }

}

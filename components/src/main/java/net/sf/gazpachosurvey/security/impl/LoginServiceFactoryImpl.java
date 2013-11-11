package net.sf.gazpachosurvey.security.impl;

import java.util.Map;
import java.util.Set;

import net.sf.gazpachosurvey.security.LoginService;
import net.sf.gazpachosurvey.security.LoginServiceFactory;
import net.sf.gazpachosurvey.security.LoginServiceType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class LoginServiceFactoryImpl implements LoginServiceFactory {

    private Map<String, LoginService> implementations;


    public void setImplementations(
            Map<String, LoginService> loginServiceImplementations) {
        this.implementations = loginServiceImplementations;
    }

    @Override
    public LoginService getObject(LoginServiceType type) {
        Set<String> keys = implementations.keySet();
        for (String string : keys) {
            System.out.println(string);
        }
        LoginService impl = implementations.get(type.toString());
        if (impl == null) {
            throw new IllegalStateException(
                    "There is no implementation for type = " + type);
        }
        return impl;
    }

}

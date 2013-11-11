package net.sf.gazpachosurvey.security;

public interface LoginServiceFactory {

    LoginService getObject(LoginServiceType type);
}

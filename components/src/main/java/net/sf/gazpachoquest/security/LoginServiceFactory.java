package net.sf.gazpachoquest.security;

public interface LoginServiceFactory {

    LoginService getObject(LoginServiceType type);
}

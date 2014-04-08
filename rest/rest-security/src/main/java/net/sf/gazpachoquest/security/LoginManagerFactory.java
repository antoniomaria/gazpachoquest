package net.sf.gazpachoquest.security;

public interface LoginManagerFactory {

    LoginManager getObject(AccountType type);
}

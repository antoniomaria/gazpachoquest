package net.sf.gazpachoquest.security;

public interface AuthenticationManagerFactory {

    AuthenticationManager getObject(AccountType type);
}

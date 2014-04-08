package net.sf.gazpachoquest.security;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.dto.auth.Account;

public interface LoginManager {

    Account login(String apiKey) throws AccountNotFoundException;
}

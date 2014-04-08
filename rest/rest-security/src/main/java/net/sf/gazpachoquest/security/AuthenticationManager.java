package net.sf.gazpachoquest.security;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.dto.auth.Account;

public interface AuthenticationManager {

    Account authenticate(String username, String password) throws AccountNotFoundException;

}

/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.jaas.mock;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class CallbackHandlerMock implements CallbackHandler {

    private String username;

    private String password;

    public CallbackHandlerMock() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        ((NameCallback) callbacks[0]).setName(username);
        ((PasswordCallback) callbacks[1]).setPassword(password.toCharArray());
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public CallbackHandlerMock build() {
            CallbackHandlerMock callbackHandlerMock = new CallbackHandlerMock();
            callbackHandlerMock.username = username;
            callbackHandlerMock.password = password;
            return callbackHandlerMock;
        }
    }
}

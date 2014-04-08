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
package net.sf.gazpachoquest.jaas;

import java.security.Principal;

public class UserPrincipal implements Principal {

    private String name;

    private String password;

    public UserPrincipal() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String password;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserPrincipal build() {
            UserPrincipal userPrincipal = new UserPrincipal();
            userPrincipal.name = name;
            userPrincipal.password = password;
            return userPrincipal;
        }
    }
}

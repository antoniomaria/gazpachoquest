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
package net.sf.gazpachoquest.dto;

public class ManagerDTO extends AbstractUserDTO {

    private static final long serialVersionUID = 7370786032611110768L;

    private String username;

    public ManagerDTO() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class Builder {
        private String email;
        private String givenNames;
        private String surname;
        private String username;

        public ManagerDTO build() {
            ManagerDTO managerDTO = new ManagerDTO();
            managerDTO.setGivenNames(givenNames);
            managerDTO.setSurname(surname);
            managerDTO.setEmail(email);
            managerDTO.setUsername(username);
            return managerDTO;
        }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder givenNames(final String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }
}

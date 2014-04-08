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

import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

public class ParticipantDTO extends AbstractUserDTO {

    private static final long serialVersionUID = 1284879816117827887L;

    public ParticipantDTO() {
        super();
    }

    public static class Builder {
        private String email;
        private String givenNames;
        private Gender gender;
        private Integer id;
        private String surname;
        private Language preferedLanguage;

        public ParticipantDTO build() {
            ParticipantDTO participantDTO = new ParticipantDTO();
            participantDTO.setId(id);
            participantDTO.setGivenNames(givenNames);
            participantDTO.setSurname(surname);
            participantDTO.setEmail(email);
            participantDTO.setGender(gender);
            participantDTO.setPreferedLanguage(preferedLanguage);
            return participantDTO;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder givenNames(final String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder id(final Integer id) {
            this.id = id;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public Builder preferedLanguage(final Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }

}

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
package net.sf.gazpachoquest.domain.user;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.support.User;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

@Entity
@DiscriminatorValue("P")
public class Participant extends User {

    private static final long serialVersionUID = 6716148852807992302L;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    private Set<Questionnair> questionnairs;

    public Participant() {
        super();
    }

    public Set<Questionnair> getQuestionnairs() {
        return questionnairs;
    }

    public void setQuestionnairs(Set<Questionnair> questionnairs) {
        this.questionnairs = questionnairs;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String givenNames;
        private String surname;
        private String email;
        private Language preferedLanguage;
        private Gender gender;
        private String apiKey;

        private Set<Questionnair> questionnairs;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder giveNames(String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder preferedLanguage(Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder questionnairs(Set<Questionnair> questionnairs) {
            this.questionnairs = questionnairs;
            return this;
        }

        public Participant build() {
            Participant participant = new Participant();
            participant.setId(id);
            participant.setApiKey(apiKey);
            participant.setGivenNames(givenNames);
            participant.setSurname(surname);
            participant.setEmail(email);
            participant.setPreferedLanguage(preferedLanguage);
            participant.setGender(gender);
            participant.questionnairs = questionnairs;
            return participant;
        }
    }

}

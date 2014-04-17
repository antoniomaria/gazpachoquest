/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.InvitationStatus;

@Entity
@DiscriminatorValue("P")
public class PersonalInvitation extends Invitation {

    private static final long serialVersionUID = -9203813369476903640L;

    @ManyToOne(fetch = FetchType.LAZY)
    private User respondent;

    public PersonalInvitation() {
        super();
    }

    public User getRespondent() {
        return respondent;
    }

    public void setRespondent(User respondent) {
        this.respondent = respondent;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder extends Invitation.Builder {

        private String token;
        private Research research;
        private InvitationStatus status;
        private User respondent;

        @Override
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public Builder research(Research research) {
            this.research = research;
            return this;
        }

        public Builder respondent(User respondent) {
            this.respondent = respondent;
            return this;
        }

        @Override
        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public PersonalInvitation build() {
            return new PersonalInvitation(this);
        }
    }

    private PersonalInvitation(Builder builder) {
        super(builder.token, builder.research, builder.status);
        this.respondent = builder.respondent;
    }
}

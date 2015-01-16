/*
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 */
package net.sf.gazpachoquest.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.types.InvitationStatus;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("A")
public class AnonymousInvitation extends Invitation {

    public AnonymousInvitation() {
        super();
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder extends Invitation.Builder {

        private String token;
        private Research research;
        private InvitationStatus status;

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

        @Override
        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public AnonymousInvitation build() {
            return new AnonymousInvitation(this);
        }
    }

    private AnonymousInvitation(Builder builder) {
        super(builder.token, builder.research, builder.status);
    }

}

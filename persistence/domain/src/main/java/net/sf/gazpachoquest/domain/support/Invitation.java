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
package net.sf.gazpachoquest.domain.support;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.types.InvitationStatus;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Invitation extends AbstractPersistable {

    private static final long serialVersionUID = -9203813369476903640L;

    @Column(nullable = false)
    protected String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected Research research;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected InvitationStatus status;

    public Invitation() {
        super();
    }

    protected Invitation(String token, Research research, InvitationStatus status) {
        super();
        this.token = token;
        this.research = research;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String token;
        private Research research;
        private InvitationStatus status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder research(Research research) {
            this.research = research;
            return this;
        }

        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Invitation build() {
            Invitation invitation = new Invitation();
            invitation.token = token;
            invitation.research = research;
            invitation.status = status;
            invitation.setId(id);
            return invitation;
        }
    }
}

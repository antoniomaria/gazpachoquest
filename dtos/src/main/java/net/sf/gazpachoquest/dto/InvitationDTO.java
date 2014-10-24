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

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.InvitationStatus;
import net.sf.gazpachoquest.types.InvitationType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = AnonymousInvitationDTO.class, name = "A"),
        @JsonSubTypes.Type(value = PersonalInvitationDTO.class, name = "P") })
public class InvitationDTO extends AbstractIdentifiableDTO {
    private static final long serialVersionUID = -2776483997831033883L;

    private InvitationStatus status;

    private ResearchDTO research;

    private String token;

    private InvitationType type;

    public InvitationStatus getStatus() {
        return status;
    }

    public ResearchDTO getResearch() {
        return research;
    }

    public String getToken() {
        return token;
    }

    @JsonIgnore
    public InvitationType getType() {
        return type;
    }

    public void setStatus(final InvitationStatus status) {
        this.status = status;
    }

    public void setResearch(final ResearchDTO research) {
        this.research = research;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setType(final InvitationType type) {
        this.type = type;
    }

    public static class Builder {
        private InvitationStatus status;
        private ResearchDTO research;

        private String token = "";
        private InvitationType type;

        public InvitationDTO build() {
            InvitationDTO invitationDTO = new InvitationDTO();
            invitationDTO.token = token;
            invitationDTO.research = research;
            invitationDTO.status = status;
            invitationDTO.type = type;
            return invitationDTO;
        }

        public Builder status(final InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Builder research(final ResearchDTO research) {
            this.research = research;
            return this;
        }

        public Builder token(final String token) {
            this.token = token;
            return this;
        }

        public Builder type(final InvitationType type) {
            this.type = type;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }

}

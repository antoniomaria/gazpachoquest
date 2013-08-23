package net.sf.gazpachosurvey.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ParticipantDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = 1284879816117827887L;

    private String firstname;

    private String lastname;

    private String email;

    public ParticipantDTO() {
        super();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String email;

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public ParticipantDTO build() {
            ParticipantDTO participantDTO = new ParticipantDTO();
            participantDTO.firstname = firstname;
            participantDTO.lastname = lastname;
            participantDTO.email = email;
            return participantDTO;
        }
    }

}

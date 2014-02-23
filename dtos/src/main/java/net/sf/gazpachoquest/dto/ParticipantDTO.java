package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

public class ParticipantDTO extends AbstractIdentifiableDTO {

    public static class Builder {
        private String email;
        private String firstname;
        private Gender gender;
        private Integer id;
        private String lastname;
        private Language preferedLanguage;

        public ParticipantDTO build() {
            ParticipantDTO participantDTO = new ParticipantDTO();
            participantDTO.setId(id);
            participantDTO.firstname = firstname;
            participantDTO.lastname = lastname;
            participantDTO.email = email;
            participantDTO.gender = gender;
            participantDTO.preferedLanguage = preferedLanguage;
            return participantDTO;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder firstname(final String firstname) {
            this.firstname = firstname;
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

        public Builder lastname(final String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder preferedLanguage(final Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }
    }

    private static final long serialVersionUID = 1284879816117827887L;

    public static Builder with() {
        return new Builder();
    }

    private String email;

    private String firstname;

    private Gender gender;

    private String lastname;

    private Language preferedLanguage;

    public ParticipantDTO() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public void setPreferedLanguage(final Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

}

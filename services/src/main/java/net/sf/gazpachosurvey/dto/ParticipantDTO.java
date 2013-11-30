package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.Gender;
import net.sf.gazpachosurvey.types.Language;

public class ParticipantDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = 1284879816117827887L;

    private String firstname;

    private String lastname;

    private String email;

    private Gender gender;

    private Language preferedLanguage;

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

    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    public void setPreferedLanguage(Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private Language preferedLanguage;
        private Gender gender;

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

        public Builder preferedLanguage(Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public ParticipantDTO build() {
            ParticipantDTO participantDTO = new ParticipantDTO();
            participantDTO.firstname = firstname;
            participantDTO.lastname = lastname;
            participantDTO.email = email;
            participantDTO.gender = gender;
            participantDTO.preferedLanguage = preferedLanguage;
            return participantDTO;
        }
    }

}

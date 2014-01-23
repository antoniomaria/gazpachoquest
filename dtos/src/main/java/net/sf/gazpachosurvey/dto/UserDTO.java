package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;

public class UserDTO extends AbstractIdentifiableDTO {

    public static class Builder {
        private String email;
        private String firstName;
        private String lastName;

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.firstName = firstName;
            userDTO.lastName = lastName;
            userDTO.email = email;
            return userDTO;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }
    }

    private static final long serialVersionUID = 7370786032611110768L;

    public static Builder with() {
        return new Builder();
    }

    private String email;

    private String firstName;

    private String lastName;

    public UserDTO() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}

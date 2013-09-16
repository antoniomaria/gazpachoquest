package net.sf.gazpachosurvey.dto;


public class UserDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = 7370786032611110768L;

    private String firstName;

    private String lastName;

    private String email;
    
    public UserDTO(){
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static Builder with(){
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.firstName = firstName;
            userDTO.lastName = lastName;
            userDTO.email = email;
            return userDTO;
        }
    }
}

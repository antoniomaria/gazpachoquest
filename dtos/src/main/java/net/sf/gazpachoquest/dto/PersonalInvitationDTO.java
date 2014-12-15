package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.types.InvitationType;

@SuppressWarnings("serial")
public class PersonalInvitationDTO extends InvitationDTO {

    private UserDTO respondent;

    public PersonalInvitationDTO() {
        super();
        super.setType(InvitationType.PERSONAL);
    }

    public UserDTO getRespondent() {
        return respondent;
    }

    public void setRespondent(UserDTO respondent) {
        this.respondent = respondent;
    }

}

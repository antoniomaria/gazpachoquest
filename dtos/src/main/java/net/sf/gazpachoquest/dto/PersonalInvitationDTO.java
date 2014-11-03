package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.types.InvitationType;

public class PersonalInvitationDTO extends InvitationDTO{
    
    private static final long serialVersionUID = 3478435429719736340L;
    
    private UserDTO respondent;

    public PersonalInvitationDTO(){
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

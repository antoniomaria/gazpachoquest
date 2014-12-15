package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.types.InvitationType;

@SuppressWarnings("serial")
public class AnonymousInvitationDTO extends InvitationDTO {

    public AnonymousInvitationDTO() {
        super();
        super.setType(InvitationType.ANONYMOUS);
    }

}

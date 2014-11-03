package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.types.InvitationType;

public class AnonymousInvitationDTO extends InvitationDTO {

    private static final long serialVersionUID = 3478435429719736340L;

    public AnonymousInvitationDTO() {
        super();
        super.setType(InvitationType.ANONYMOUS);
    }

}

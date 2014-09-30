package net.sf.gazpachoquest.facades;

import java.util.List;

import net.sf.gazpachoquest.dto.InvitationDTO;

public interface InvitationFacade {

    List<InvitationDTO> findByExample(InvitationDTO invitationDTO);

}

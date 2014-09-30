package net.sf.gazpachoquest.facades.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.dto.AnonymousInvitationDTO;
import net.sf.gazpachoquest.dto.InvitationDTO;
import net.sf.gazpachoquest.dto.PersonalInvitationDTO;
import net.sf.gazpachoquest.facades.InvitationFacade;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.services.InvitationService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class InvitationFacadeImpl implements InvitationFacade{

    @Autowired
    private Mapper mapper;
    
    @Autowired
    private InvitationService invitationService;
    
    @Override
    public List<InvitationDTO> findByExample(InvitationDTO invitationDTO){
        Invitation example = null;
        if (invitationDTO instanceof PersonalInvitationDTO){
            example = mapper.map(invitationDTO, PersonalInvitation.class);    
        }else if(invitationDTO instanceof AnonymousInvitationDTO){
            example = mapper.map(invitationDTO, AnonymousInvitation.class);
        }else{
            example = mapper.map(invitationDTO, Invitation.class);
        }
        List<Invitation> invitations = invitationService.findByExample(example, new SearchParameters());
        List<InvitationDTO> invitationDTOs = new ArrayList<InvitationDTO>();
        for (Invitation invitation : invitations) {
            if (invitation instanceof PersonalInvitation){
               invitationDTOs.add(mapper.map(invitation, PersonalInvitationDTO.class));
            }else{
                invitationDTOs.add(mapper.map(invitation, AnonymousInvitationDTO.class));
            }
        }
        return invitationDTOs;
    }
    
}

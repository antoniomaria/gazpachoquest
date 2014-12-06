package net.sf.gazpachoquest.facades.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.dto.AnonymousInvitationDTO;
import net.sf.gazpachoquest.dto.InvitationDTO;
import net.sf.gazpachoquest.dto.PersonalInvitationDTO;
import net.sf.gazpachoquest.facades.InvitationFacade;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.services.PersonalInvitationService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class InvitationFacadeImpl implements InvitationFacade{

    @Autowired
    private Mapper mapper;
    
    @Autowired
    private InvitationService invitationService;
    
    @Autowired
    private PersonalInvitationService personalInvitationService;
    
    @Override
    public List<InvitationDTO> findByExample(InvitationDTO invitationDTO){
        Invitation example = null;
        List<?> invitations = Collections.emptyList();
        if (invitationDTO instanceof PersonalInvitationDTO){
            PersonalInvitation personalInvitationExample = mapper.map(invitationDTO, PersonalInvitation.class);
            invitations = personalInvitationService.findByExample(personalInvitationExample, new SearchParameters());
        }else if(invitationDTO instanceof AnonymousInvitationDTO){
            example = mapper.map(invitationDTO, AnonymousInvitation.class);
        }else{
            example = mapper.map(invitationDTO, Invitation.class);
            invitations = invitationService.findByExample(example, new SearchParameters());
        }
        List<InvitationDTO> invitationDTOs = new ArrayList<InvitationDTO>();
        for (Iterator<?> it = invitations.iterator(); it.hasNext();) {
            Invitation invitation = (Invitation) it.next();
            if (invitation instanceof PersonalInvitation){
               invitationDTOs.add(mapper.map(invitation, PersonalInvitationDTO.class));
            }else{
                invitationDTOs.add(mapper.map(invitation, AnonymousInvitationDTO.class));
            }
        }
        return invitationDTOs;
    }
    
}

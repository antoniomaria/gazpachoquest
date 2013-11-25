package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.dto.InvitationDTO;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.services.InvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitationServiceImpl extends AbstractPersistenceService<Invitation, InvitationDTO> implements
        InvitationService {

    @Autowired
    protected InvitationServiceImpl(InvitationRepository repository) {
        super(repository, Invitation.class, InvitationDTO.class);
    }

}

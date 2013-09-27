package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.services.ParticipantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl extends AbstractPersistenceService<Participant, ParticipantDTO> implements
        ParticipantService {

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository repository) {
        super(repository, Participant.class, ParticipantDTO.class);
    }

}

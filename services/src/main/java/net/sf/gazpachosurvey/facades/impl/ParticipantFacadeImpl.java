package net.sf.gazpachosurvey.facades.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.facades.ParticipantFacade;
import net.sf.gazpachosurvey.services.ParticipantService;

@Component
public class ParticipantFacadeImpl implements ParticipantFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ParticipantService participantService;

    @Override
    public ParticipantDTO save(ParticipantDTO participant) {
        Participant entity = mapper.map(participant, Participant.class);
        return mapper.map(participantService.save(entity), ParticipantDTO.class);
    }

    @Override
    public ParticipantDTO findOne(Integer id) {
        return mapper.map(participantService.findOne(id), ParticipantDTO.class);
    }
    
    @Override
    public void delete(Integer id) {
        participantService.delete(id);
    }
    
}

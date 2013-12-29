package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.facades.ParticipantFacade;
import net.sf.gazpachosurvey.services.ParticipantService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipantFacadeImpl implements ParticipantFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ParticipantService participantService;

    @Override
    public void delete(final Integer id) {
        participantService.delete(id);
    }

    @Override
    public ParticipantDTO findOne(final Integer id) {
        return mapper.map(participantService.findOne(id), ParticipantDTO.class);
    }

    @Override
    public ParticipantDTO save(final ParticipantDTO participant) {
        Participant entity = mapper.map(participant, Participant.class);
        return mapper.map(participantService.save(entity), ParticipantDTO.class);
    }

}

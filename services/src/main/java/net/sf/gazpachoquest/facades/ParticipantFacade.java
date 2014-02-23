package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.ParticipantDTO;

public interface ParticipantFacade {

    void delete(Integer id);

    ParticipantDTO findOne(Integer id);

    ParticipantDTO save(ParticipantDTO participant);

}

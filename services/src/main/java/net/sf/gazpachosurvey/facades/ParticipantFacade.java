package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.ParticipantDTO;

public interface ParticipantFacade {

    ParticipantDTO save(ParticipantDTO participant);

    ParticipantDTO findOne(Integer id);

    void delete(Integer id);

}

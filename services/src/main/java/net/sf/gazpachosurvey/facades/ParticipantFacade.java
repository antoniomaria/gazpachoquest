package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.ParticipantDTO;

public interface ParticipantFacade {

    void delete(Integer id);

    ParticipantDTO findOne(Integer id);

    ParticipantDTO save(ParticipantDTO participant);

}

package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.StudyDTO;

public interface StudyFacade {

    void delete(Integer id);

    StudyDTO findOne(Integer id);

    StudyDTO save(StudyDTO study);

}

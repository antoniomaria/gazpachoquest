package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.StudyDTO;

public interface StudyFacade {

    void delete(Integer id);

    StudyDTO findOne(Integer id);

    StudyDTO save(StudyDTO surveyInstance);

}

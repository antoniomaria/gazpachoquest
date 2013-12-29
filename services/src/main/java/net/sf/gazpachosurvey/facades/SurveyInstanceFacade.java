package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.SurveyInstanceDTO;

public interface SurveyInstanceFacade {

    void delete(Integer id);

    SurveyInstanceDTO findOne(Integer id);

    SurveyInstanceDTO save(SurveyInstanceDTO surveyInstance);

}

package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.SurveyInstanceDTO;

public interface SurveyInstanceFacade {

    SurveyInstanceDTO save(SurveyInstanceDTO surveyInstance);

    void delete(Integer id);

    SurveyInstanceDTO findOne(Integer id);

}

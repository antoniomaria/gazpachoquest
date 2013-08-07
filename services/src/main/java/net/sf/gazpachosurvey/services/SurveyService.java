package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;

public interface SurveyService {
    
    Integer addSurvey(SurveyDTO survey);

    Integer addPage(Integer surveyId, PageDTO page);
}

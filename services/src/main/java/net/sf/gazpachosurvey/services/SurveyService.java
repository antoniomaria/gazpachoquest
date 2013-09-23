package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.SurveyDTO;

public interface SurveyService extends LocalizedPersistenceService<SurveyDTO, Integer> {

    SurveyDTO confirm(SurveyDTO survey);
}

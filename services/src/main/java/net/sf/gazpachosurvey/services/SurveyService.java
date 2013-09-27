package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.SurveyDTO;

public interface SurveyService extends LocalizedPersistenceService<SurveyDTO> {

    SurveyDTO confirm(SurveyDTO survey);
}

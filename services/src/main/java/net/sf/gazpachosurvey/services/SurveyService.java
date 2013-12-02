package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;

public interface SurveyService extends LocalizedPersistenceService<SurveyDTO, SurveyLanguageSettingsDTO> {

    SurveyDTO confirm(SurveyDTO survey);

    Survey save(Survey survey);

}

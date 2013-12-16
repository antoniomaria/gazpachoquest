package net.sf.gazpachosurvey.facades;

import java.util.Set;

import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.types.Language;

public interface SurveyAccessorFacade {

    SurveyDTO findOneSurvey(Integer surveyId);

    Set<Language> findSurveyTranslations(Integer surveyId);

}

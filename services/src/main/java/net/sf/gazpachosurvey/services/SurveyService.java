package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;

public interface SurveyService extends LocalizedPersistenceService<Survey, SurveyTranslation, SurveyLanguageSettings> {

    Survey confirm(Survey survey);

    long questionGroupsCount(Integer surveyId);

}

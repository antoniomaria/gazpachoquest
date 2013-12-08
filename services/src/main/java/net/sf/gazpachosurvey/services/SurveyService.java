package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;

public interface SurveyService extends LocalizedPersistenceService<Survey, SurveyLanguageSettings> {

    Survey confirm(Survey survey);

}

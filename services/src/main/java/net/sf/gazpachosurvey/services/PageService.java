package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;

public interface PageService extends LocalizedPersistenceService<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> {
    QuestionGroupDTO addPage(Integer surveyId, QuestionGroupDTO page);
}

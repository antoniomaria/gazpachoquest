package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;

public interface QuestionGroupService extends LocalizedPersistenceService<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> {
    QuestionGroupDTO addQuestionGroup(Integer surveyId, QuestionGroupDTO page);
}

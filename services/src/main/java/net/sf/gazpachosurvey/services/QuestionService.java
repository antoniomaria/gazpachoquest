package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;

public interface QuestionService extends LocalizedPersistenceService<QuestionDTO, QuestionLanguageSettingsDTO> {

    Integer addQuestion(Integer pageId, QuestionDTO question);

}

package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.QuestionDTO;

public interface QuestionService extends PersistenceService<QuestionDTO> {

    Integer addQuestion(Integer pageId, QuestionDTO question);

}

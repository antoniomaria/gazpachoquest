package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;

public interface QuestionService extends PersistenceService<QuestionDTO, Integer> {
    Integer addQuestion(Integer pageId, QuestionDTO question);
}

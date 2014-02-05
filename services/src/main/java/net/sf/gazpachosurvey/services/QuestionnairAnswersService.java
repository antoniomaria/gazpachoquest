package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Questionnair;

public interface QuestionnairAnswersService {

    Object findByQuestionCode(Questionnair questionnair, String questionCode);

    void save(Questionnair questionnair, String questionCode, String answer);

}

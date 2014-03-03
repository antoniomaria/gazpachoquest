package net.sf.gazpachoquest.services;

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnair;

public interface QuestionnairAnswersService {

    Object findByQuestionCode(Questionnair questionnair, String questionCode);

    Map<String, Object> findByQuestionnair(Questionnair questionnair);

    void save(Questionnair questionnair, String questionCode, Object answer);

}

package net.sf.gazpachoquest.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;

public interface QuestionnairAnswersRepository {

    String ENTITY_NAME_PREFIX = "questionnair_answers_";

    void activeAllAnswers();

    void collectAnswers(QuestionnairDefinition questionnairDefinition);

    QuestionnairAnswers findByOne(Integer questionnairDefinitionId, Integer id);

    QuestionnairAnswers save(Integer questionnairDefinitionId, QuestionnairAnswers questionnairAnswers);

}

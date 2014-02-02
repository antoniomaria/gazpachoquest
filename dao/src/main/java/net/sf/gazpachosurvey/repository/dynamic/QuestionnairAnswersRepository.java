package net.sf.gazpachosurvey.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;

public interface QuestionnairAnswersRepository {

    String ENTITY_NAME_PREFIX = "questionnairanswers";

    void activeAllAnswers();

    void collectAnswers(QuestionnairDefinition questionnairDefinition);

    QuestionnairAnswers save(QuestionnairAnswers questionnairAnswers);

    QuestionnairAnswers findByOne(QuestionnairDefinition questionnairDefinition, Integer id);

    QuestionnairAnswers mySaveTest(QuestionnairAnswers questionnairAnswers);
}

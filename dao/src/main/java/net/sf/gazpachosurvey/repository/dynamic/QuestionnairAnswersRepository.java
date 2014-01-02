package net.sf.gazpachosurvey.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;

public interface QuestionnairAnswersRepository {

    String TABLE_NAME_PREFIX = "questionnair_answers_";

    void activeAllAnswers();

    void collectAnswers(QuestionnairDefinition questionnairDefinition);

    QuestionnairAnswers save(QuestionnairAnswers questionnairAnswers);
}

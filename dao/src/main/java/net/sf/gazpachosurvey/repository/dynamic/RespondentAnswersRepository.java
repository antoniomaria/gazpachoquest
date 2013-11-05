package net.sf.gazpachosurvey.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.RespondentAnswers;
import net.sf.gazpachosurvey.domain.core.Survey;

public interface RespondentAnswersRepository {

    String TABLE_NAME_PREFIX = "respondent_answers_";
    
    void collectAnswers(Survey survey);

    void enableAllAnswers();

    RespondentAnswers save(RespondentAnswers respondent);
}

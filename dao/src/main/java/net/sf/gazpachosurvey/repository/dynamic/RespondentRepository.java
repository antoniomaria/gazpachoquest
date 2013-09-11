package net.sf.gazpachosurvey.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;

public interface RespondentRepository {

    void collectAnswers(Survey survey);

    void enableAllAnswers();

    void save(Respondent respondent);
}

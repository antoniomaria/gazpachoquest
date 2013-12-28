package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;

public interface QuestionService extends
        LocalizedPersistenceService<Question, QuestionTranslation, QuestionLanguageSettings> {

    Question findOneByPositionInQuestionGroup(Integer questionGroupId, Integer position);

    Integer findPositionInQuestionGroup(Integer questionId);

}

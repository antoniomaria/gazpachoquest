package net.sf.gazpachoquest.services;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;

public interface QuestionService extends
        LocalizedPersistenceService<Question, QuestionTranslation, QuestionLanguageSettings> {

    Question findOneByPositionInQuestionGroup(Integer questionGroupId, Integer position);

    Integer findPositionInQuestionGroup(Integer questionId);

}

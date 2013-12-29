package net.sf.gazpachosurvey.services;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;

public interface QuestionGroupService extends
        LocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings> {

    List<QuestionGroup> findBySurveyId(Integer surveyId);

    QuestionGroup findOneByPositionInSurvey(Integer surveyId, Integer position);

    Integer findPositionInSurvey(Integer questionGroupId);

    long questionsCount(Integer questionGroupId);
}

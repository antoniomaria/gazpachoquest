package net.sf.gazpachosurvey.services;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;

public interface QuestionGroupService extends
        LocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings> {

    Integer findPositionInSurvey(Integer questionGroupId);

    QuestionGroup findOneByPositionInSurvey(Integer surveyId, Integer position);

    List<QuestionGroup> findBySurveyId(Integer surveyId);

    long questionsCount(Integer questionGroupId);
}

package net.sf.gazpachoquest.services;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;

public interface QuestionGroupService extends
        LocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings> {

    List<QuestionGroup> findByQuestionnairDefinitionId(Integer questionnairDefinitionId);

    QuestionGroup findOneByPositionInQuestionnairDefinition(Integer questionnairDefinitionId, Integer position);

    Integer findPositionInSurvey(Integer questionGroupId);

    long questionsCount(Integer questionGroupId);
}

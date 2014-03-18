package net.sf.gazpachoquest.facades;

import java.util.Set;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.types.Language;

public interface QuestionnairDefinitionAccessorFacade {

    QuestionnairDefinitionDTO findOneQuestionnairDefinition(Integer questionnairDefinitionId);

    Set<Language> findQuestionnairDefinitionTranslations(Integer questionnairDefinitionId);

    QuestionDTO findOneQuestion(Integer questionId);

}

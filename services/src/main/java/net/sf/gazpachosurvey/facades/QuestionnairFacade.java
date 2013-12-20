package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;

public interface QuestionnairFacade {

    QuestionnairDefinitionDTO findQuestionnairDefinitionFor(Respondent respondent);
}

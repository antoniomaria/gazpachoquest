package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairPageDTO;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.RenderingMode;

public interface QuestionnairFacade {

    QuestionnairPageDTO composeQuestionnairPage(Respondent respondent, RenderingMode mode, BrowsingAction action,
            Language language);

    QuestionnairDefinitionDTO findQuestionnairDefinitionFor(Respondent respondent);
}

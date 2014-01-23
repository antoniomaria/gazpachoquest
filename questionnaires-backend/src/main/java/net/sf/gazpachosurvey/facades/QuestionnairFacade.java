package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.QuestionnairDTO;

public interface QuestionnairFacade {

    QuestionnairDTO findOne(Integer questionnairId);

}

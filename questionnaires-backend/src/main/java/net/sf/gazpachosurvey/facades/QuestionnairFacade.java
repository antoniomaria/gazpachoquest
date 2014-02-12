package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDTO;
import net.sf.gazpachosurvey.dto.answers.Answer;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.RenderingMode;

public interface QuestionnairFacade {

    QuestionnairDTO findOne(Integer questionnairId);

    PageDTO resolvePage(Integer questionnairId, RenderingMode mode, BrowsingAction action);

    void saveAnswer(Integer questionnairId, String questionCode, Answer answer);

}

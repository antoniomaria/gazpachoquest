package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

public interface QuestionnairFacade {

    QuestionnairDTO findOne(Integer questionnairId);

    PageDTO resolvePage(Integer questionnairId, RenderingMode mode, BrowsingAction action);

    void saveAnswer(Integer questionnairId, String questionCode, Answer answer);

}

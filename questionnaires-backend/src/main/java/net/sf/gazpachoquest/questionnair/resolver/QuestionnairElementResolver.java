package net.sf.gazpachoquest.questionnair.resolver;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.support.QuestionnairElement;
import net.sf.gazpachoquest.types.BrowsingAction;

public interface QuestionnairElementResolver {

    QuestionnairElement resolveFor(Questionnair questionnair, BrowsingAction action);

}
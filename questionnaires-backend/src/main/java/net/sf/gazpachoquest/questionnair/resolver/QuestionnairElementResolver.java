package net.sf.gazpachoquest.questionnair.resolver;

import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.support.QuestionnairElement;

public interface QuestionnairElementResolver {

    QuestionnairElement resolveFor(Questionnair questionnair, BrowsingAction action);

}
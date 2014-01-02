package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.support.QuestionnairElement;
import net.sf.gazpachosurvey.types.BrowsingAction;

public interface QuestionnairElementResolver {

    QuestionnairElement resolveFor(Questionnair respondent, BrowsingAction action);

}
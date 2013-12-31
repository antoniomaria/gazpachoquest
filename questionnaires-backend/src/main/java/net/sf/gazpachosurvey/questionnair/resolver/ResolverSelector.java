package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.types.RenderingMode;

public interface ResolverSelector {

    QuestionnairElementResolver selectBy(RenderingMode mode);
}

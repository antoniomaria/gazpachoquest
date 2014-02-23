package net.sf.gazpachoquest.questionnair.resolver;

import net.sf.gazpachoquest.types.RenderingMode;

public interface ResolverSelector {

    QuestionnairElementResolver selectBy(RenderingMode mode);
}

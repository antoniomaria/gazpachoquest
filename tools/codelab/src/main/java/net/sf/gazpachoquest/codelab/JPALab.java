package net.sf.gazpachoquest.codelab;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.questionnair.resolver.QuestionnairElementResolver;
import net.sf.gazpachoquest.types.NavigationAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JPALab {
    
    @Autowired
    @Qualifier("GroupByGroupResolver")
    private QuestionnairElementResolver resolver;
    
    public void execute() {
        resolver.resolveNextPage(Questionnair.with().id(64).build(), NavigationAction.ENTERING);
    }
}

package net.sf.gazpachoquest.questionnair.resolver;

import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResolverSelectorImpl implements ResolverSelector {

    @Autowired
    @Qualifier("GroupByGroupResolver")
    QuestionnairElementResolver groupByGroupResolver;

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    QuestionnairElementResolver questionByQuestionResolver;

    @Override
    public QuestionnairElementResolver selectBy(RenderingMode mode) {
        QuestionnairElementResolver resolver = null;
        switch (mode) {
        case QUESTION_BY_QUESTION:
            resolver = questionByQuestionResolver;
            break;
        case GROUP_BY_GROUP:
            resolver = groupByGroupResolver;
            break;
        default:
            break;
        }
        return resolver;
    }

}

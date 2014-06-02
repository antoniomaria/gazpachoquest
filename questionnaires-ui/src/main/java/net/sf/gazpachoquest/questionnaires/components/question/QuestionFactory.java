package net.sf.gazpachoquest.questionnaires.components.question;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.resource.NotSupportedException;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.questionnaires.components.question.type.ShortFreeTextQuestion;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class QuestionFactory {

    private static final Logger logger = LoggerFactory.getLogger(QuestionFactory.class);

    @Inject
    Instance<AbstractQuestionComponent> question;

    @GazpachoResource
    @Inject
    private QuestionnairResource questionnairResource;

    @PostConstruct
    public void init() {
        logger.debug("Question Factory instance created");
    }

    public QuestionComponent build(Integer questionnairId, QuestionDTO questionDTO) throws NotSupportedException {
        AbstractQuestionComponent questionComponent = null;
        switch (questionDTO.getType()) {
        case S:
            questionComponent = question.select(ShortFreeTextQuestion.class).get();
        case F:
            break;
        case L:
            break;
        case M:
            break;
        case N:
            break;
        case T:
            break;
        default:
            throw new NotSupportedException("Question Type " + questionDTO.getType() + " not supported");
        }
        questionComponent.setQuestionDTO(questionDTO);
        questionComponent.init();
        return questionComponent;
    }

}

package net.sf.gazpachoquest.questionnair.resolver;

import java.util.List;

import net.sf.gazpachoquest.repository.BrowsedElementRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.qbe.SearchParameters;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("QuestionByQuestionResolver")
public class QuestionByQuestionResolverImpl implements QuestionnairElementResolver {
    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(QuestionByQuestionResolverImpl.class);

    @Autowired
    private BrowsedElementRepository browsedElementService;

    @Autowired
    private QuestionGroupRepository questionGroupService;

    @Autowired
    private QuestionRepository questionService;

    @Autowired
    private QuestionnairDefinitionRepository surveyRepository;

    @Override
    public Question resolveFor(final Questionnair questionnair, final BrowsingAction action) {
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} Question for questionnair {}", action.toString(), questionnairId);

        BrowsedElement browsedElement = browsedElementService.findLast(questionnairId);
        BrowsedQuestion lastBrowsedQuestion = null;
        Question question = null;

        if (browsedElement == null) { // First time entering the questionnairDefinition
            question = findFirstQuestion(questionnairDefinitionId);
            lastBrowsedQuestion = BrowsedQuestion.with().questionnair(questionnair).question(question)
                    .last(Boolean.TRUE).build();
            browsedElementService.save(lastBrowsedQuestion);
            return question;
        } else {
            if (browsedElement instanceof BrowsedQuestion) {
                lastBrowsedQuestion = (BrowsedQuestion) browsedElement;
            } else {
                List<BrowsedElement> browsedElements = browsedElementService.findByExample(BrowsedElement.withProps()
                        .questionnair(Questionnair.with().id(questionnairId).build()).build(), new SearchParameters());
                browsedElementService.deleteInBatch(browsedElements);

                question = findFirstQuestion(questionnairDefinitionId);
                lastBrowsedQuestion = BrowsedQuestion.with().questionnair(questionnair).question(question)
                        .last(Boolean.TRUE).build();
                browsedElementService.save(lastBrowsedQuestion);
            }
        }

        if (BrowsingAction.ENTERING.equals(action)) {
            question = lastBrowsedQuestion.getQuestion();
        } else {
            if (BrowsingAction.FORWARD.equals(action)) {
                question = findNextQuestion(questionnairDefinitionId, questionnair, lastBrowsedQuestion);
            } else {// BACKWARD
                question = findPreviousQuestion(questionnairDefinitionId, questionnair, lastBrowsedQuestion);
            }
            if (question != null) {
                lastBrowsedQuestion.setLast(Boolean.FALSE);
                browsedElementService.save(lastBrowsedQuestion);
            }
        }
        return question;
    }

    private Question findFirstQuestion(int questionnairDefinitionId) {
        Question question;
        QuestionGroup initialGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                questionnairDefinitionId, INITIAL_POSITION);
        question = questionService.findOneByPositionInQuestionGroup(initialGroup.getId(), INITIAL_POSITION);
        return question;
    }

    private Question findNextQuestion(final Integer surveyId, final Questionnair respondent,
            final BrowsedQuestion lastBrowsedQuestion) {

        BrowsedElement nextBrowsedElement = browsedElementService.findNext(respondent.getId(),
                lastBrowsedQuestion.getCreatedDate());
        BrowsedQuestion nextBrowsedQuestion = null;
        Question next = null;

        if (nextBrowsedElement == null) {
            QuestionGroup lastQuestionGroup = lastBrowsedQuestion.getQuestion().getQuestionGroup();

            Integer position = questionService.findPositionInQuestionGroup(lastBrowsedQuestion.getQuestion().getId());

            long questionsCount = questionsCount(lastQuestionGroup.getId());
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupService
                        .findPositionInQuestionnairDefinition(lastQuestionGroup.getId());
                QuestionGroup nextQuestionGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                        surveyId, questionGroupPosition + 1);

                if (nextQuestionGroup == null) { // TODO handle exceptions
                    return null;
                }
                next = questionService.findOneByPositionInQuestionGroup(nextQuestionGroup.getId(), INITIAL_POSITION);
            }
            // Mark next element as last browsed.
            nextBrowsedQuestion = BrowsedQuestion.with().questionnair(respondent).question(next).last(Boolean.TRUE)
                    .build();
        } else {
            Assert.isInstanceOf(BrowsedQuestion.class, nextBrowsedElement);
            nextBrowsedQuestion = (BrowsedQuestion) nextBrowsedElement;
            next = nextBrowsedQuestion.getQuestion();
            nextBrowsedQuestion.setLast(Boolean.TRUE);
        }
        browsedElementService.save(nextBrowsedQuestion);
        return next;
    }

    public long questionsCount(final Integer questionGroupId) {
        return questionService.countByExample(
                Question.with().questionGroup(QuestionGroup.with().id(questionGroupId).build()).build(),
                new SearchParameters());
    }

    private Question findPreviousQuestion(final int surveyId, final Questionnair respondent,
            final BrowsedQuestion lastBrowsedElement) {
        BrowsedElement previousBrowsedElement = browsedElementService.findPrevious(respondent.getId(),
                lastBrowsedElement.getCreatedDate());
        if (previousBrowsedElement == null) {
            return null;
        }
        Assert.isInstanceOf(BrowsedQuestion.class, previousBrowsedElement);

        BrowsedQuestion previousBrowsedQuestion = (BrowsedQuestion) previousBrowsedElement;
        previousBrowsedQuestion.setLast(Boolean.TRUE);
        browsedElementService.save(previousBrowsedQuestion);
        return previousBrowsedQuestion.getQuestion();
    }
}

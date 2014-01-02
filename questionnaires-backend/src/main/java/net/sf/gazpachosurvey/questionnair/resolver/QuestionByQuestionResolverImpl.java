package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.services.BrowsedElementService;
import net.sf.gazpachosurvey.services.QuestionGroupService;
import net.sf.gazpachosurvey.services.QuestionService;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.BrowsingAction;

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
    private BrowsedElementService browsedElementService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SurveyService surveyRepository;

    @Override
    public Question resolveFor(final Questionnair respondent, final BrowsingAction action) {
        QuestionnairDefinition questionnairDefinition = respondent.getStudy().getSurvey();
        int surveyId = questionnairDefinition.getId();
        int respondentId = respondent.getId();
        logger.debug("Resolving Question for respondent {} and surveyId = {}", respondentId, surveyId);

        BrowsedElement browsedElement = browsedElementService.findLast(respondentId);
        BrowsedQuestion lastBrowsedQuestion = null;
        Question question = null;

        if (browsedElement == null) { // First time entering the questionnairDefinition
            QuestionGroup initialGroup = questionGroupService.findOneByPositionInSurvey(surveyId, INITIAL_POSITION);
            question = questionService.findOneByPositionInQuestionGroup(initialGroup.getId(), INITIAL_POSITION);
            lastBrowsedQuestion = BrowsedQuestion.with().questionnair(respondent).question(question).last(Boolean.TRUE)
                    .build();
            browsedElementService.save(lastBrowsedQuestion);
            return question;
        } else {
            Assert.isInstanceOf(BrowsedQuestion.class, browsedElement);
            lastBrowsedQuestion = (BrowsedQuestion) browsedElement;
        }

        switch (action) {
        case FORWARD:
            question = findNextQuestion(surveyId, respondent, lastBrowsedQuestion);
            break;
        case BACKWARD:
            question = findPreviousQuestion(surveyId, respondent, lastBrowsedQuestion);
            break;
        default:
            break;
        }
        lastBrowsedQuestion.setLast(Boolean.FALSE);
        browsedElementService.save(lastBrowsedQuestion);
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

            long questionsCount = questionGroupService.questionsCount(lastQuestionGroup.getId());
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupService.findPositionInSurvey(lastQuestionGroup.getId());
                QuestionGroup nextQuestionGroup = questionGroupService.findOneByPositionInSurvey(surveyId,
                        questionGroupPosition + 1);
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

    private Question findPreviousQuestion(final int surveyId, final Questionnair respondent,
            final BrowsedQuestion lastBrowsedElement) {
        BrowsedElement previousBrowsedElement = browsedElementService.findPrevious(respondent.getId(),
                lastBrowsedElement.getCreatedDate());
        Assert.isInstanceOf(BrowsedQuestion.class, previousBrowsedElement);

        BrowsedQuestion previousBrowsedQuestion = (BrowsedQuestion) previousBrowsedElement;
        previousBrowsedQuestion.setLast(Boolean.TRUE);
        browsedElementService.save(previousBrowsedQuestion);
        return previousBrowsedQuestion.getQuestion();
    }
}

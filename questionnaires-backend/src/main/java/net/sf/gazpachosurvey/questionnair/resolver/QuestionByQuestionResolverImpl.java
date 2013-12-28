package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.services.BrowsedElementService;
import net.sf.gazpachosurvey.services.QuestionGroupService;
import net.sf.gazpachosurvey.services.QuestionService;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.BrowsingAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("QuestionByQuestionResolver")
public class QuestionByQuestionResolverImpl implements QuestionnairElementResolver {
    private static final Logger logger = LoggerFactory.getLogger(QuestionByQuestionResolverImpl.class);

    private static final Integer INITIAL_POSITION = 0;

    @Autowired
    private BrowsedElementService browsedElementRepository;

    @Autowired
    private QuestionService questionRepository;

    @Autowired
    private QuestionGroupService questionGroupRepository;

    @Autowired
    private SurveyService surveyRepository;

    @Override
    public Question resolveFor(Respondent respondent, BrowsingAction action) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        int respondentId = respondent.getId();
        logger.debug("Resolving Question for respondent {} and surveyId = {}", respondentId, surveyId);
        BrowsedQuestion lastBrowsedQuestion = (BrowsedQuestion) browsedElementRepository.findLast(respondentId);
        Question question = null;

        if (lastBrowsedQuestion == null) { // First time entering the survey
            QuestionGroup initialGroup = questionGroupRepository.findOneByPositionInSurvey(surveyId, INITIAL_POSITION);
            question = questionRepository.findOneByPositionInQuestionGroup(initialGroup.getId(), INITIAL_POSITION);
            lastBrowsedQuestion = BrowsedQuestion.with().respondent(respondent).question(question).last(Boolean.TRUE)
                    .build();
            browsedElementRepository.save(lastBrowsedQuestion);
            return question;
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
        browsedElementRepository.save(lastBrowsedQuestion);
        return question;
    }

    private Question findNextQuestion(final Integer surveyId, final Respondent respondent,
            final BrowsedQuestion lastBrowsedQuestion) {
        BrowsedQuestion nextBrowsedQuestion = (BrowsedQuestion) browsedElementRepository.findNext(respondent.getId(),
                lastBrowsedQuestion.getCreatedDate());
        Question next = null;

        if (nextBrowsedQuestion == null) {
            QuestionGroup lastQuestionGroup = lastBrowsedQuestion.getQuestion().getQuestionGroup();

            Integer position = questionRepository
                    .findPositionInQuestionGroup(lastBrowsedQuestion.getQuestion().getId());

            long questionsCount = questionGroupRepository.questionsCount(lastQuestionGroup.getId());
            if (position < questionsCount - 1) { // Not last in group
                next = questionRepository.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupRepository.findPositionInSurvey(lastQuestionGroup.getId());
                QuestionGroup nextQuestionGroup = questionGroupRepository.findOneByPositionInSurvey(surveyId,
                        questionGroupPosition + 1);
                next = questionRepository.findOneByPositionInQuestionGroup(nextQuestionGroup.getId(), INITIAL_POSITION);
            }
            // Mark next element as last browsed.
            nextBrowsedQuestion = BrowsedQuestion.with().respondent(respondent).question(next).last(Boolean.TRUE)
                    .build();
        } else {
            next = nextBrowsedQuestion.getQuestion();
            nextBrowsedQuestion.setLast(Boolean.TRUE);
        }
        browsedElementRepository.save(nextBrowsedQuestion);
        return next;
    }

    private Question findPreviousQuestion(final int surveyId, final Respondent respondent,
            final BrowsedQuestion lastBrowsedElement) {
        BrowsedQuestion previousBrowsedQuestion = (BrowsedQuestion) browsedElementRepository.findPrevious(
                respondent.getId(), lastBrowsedElement.getCreatedDate());
        previousBrowsedQuestion.setLast(Boolean.TRUE);
        browsedElementRepository.save(previousBrowsedQuestion);
        return previousBrowsedQuestion.getQuestion();
    }
}

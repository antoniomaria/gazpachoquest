package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.BrowsedQuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.BrowsedElementRepository;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.types.BrowsingAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("GroupByGroupResolver")
public class GroupByGroupResolverImpl implements QuestionnairElementResolver {

    private static final Logger logger = LoggerFactory.getLogger(GroupByGroupResolverImpl.class);

    private static final Integer INITIAL_POSITION = 0;

    @Autowired
    private BrowsedElementRepository browsedElementRepository;

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Override
    public QuestionGroup resolveFor(Respondent respondent, BrowsingAction action) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        int respondentId = respondent.getId();
        logger.debug("Finding QuestionGroup for respondent {} and surveyId = {}", respondentId, surveyId);
        BrowsedQuestionGroup lastBrowsedQuestionGroup = (BrowsedQuestionGroup) browsedElementRepository
                .findLast(respondentId);
        QuestionGroup questionGroup = null;

        if (lastBrowsedQuestionGroup == null) { // First time entering the survey
            questionGroup = questionGroupRepository.findOneByPositionInSurvey(surveyId, INITIAL_POSITION);
            lastBrowsedQuestionGroup = BrowsedQuestionGroup.with().respondent(respondent).questionGroup(questionGroup)
                    .last(Boolean.TRUE).build();
            browsedElementRepository.save(lastBrowsedQuestionGroup);
            return questionGroup;
        }

        switch (action) {
        case FORWARD:
            questionGroup = findNextQuestionGroup(surveyId, respondent, lastBrowsedQuestionGroup);
            break;
        case BACKWARD:
            questionGroup = findPreviousQuestionGroup(surveyId, respondent, lastBrowsedQuestionGroup);
            break;
        default:
            break;
        }
        lastBrowsedQuestionGroup.setLast(Boolean.FALSE);
        browsedElementRepository.save(lastBrowsedQuestionGroup);
        return questionGroup;
    }

    private QuestionGroup findNextQuestionGroup(final Integer surveyId, final Respondent respondent,
            final BrowsedQuestionGroup lastBrowsedElement) {
        BrowsedQuestionGroup nextBrowsedQuestionGroup = (BrowsedQuestionGroup) browsedElementRepository.findNext(
                respondent.getId(), lastBrowsedElement.getCreatedDate());
        QuestionGroup next = null;

        if (nextBrowsedQuestionGroup == null) {
            Integer position = questionGroupRepository.findPositionInSurvey(lastBrowsedElement.getQuestionGroup()
                    .getId());
            next = questionGroupRepository.findOneByPositionInSurvey(surveyId, position + 1);

            // Mark next element as last browsed.
            nextBrowsedQuestionGroup = BrowsedQuestionGroup.with().respondent(respondent).questionGroup(next)
                    .last(Boolean.TRUE).build();
        } else {
            next = nextBrowsedQuestionGroup.getQuestionGroup();
            nextBrowsedQuestionGroup.setLast(Boolean.TRUE);
        }
        browsedElementRepository.save(nextBrowsedQuestionGroup);
        return next;
    }

    private QuestionGroup findPreviousQuestionGroup(final int surveyId, final Respondent respondent,
            final BrowsedQuestionGroup lastBrowsedElement) {
        BrowsedQuestionGroup previousBrowsedQuestionGroup = (BrowsedQuestionGroup) browsedElementRepository
                .findPrevious(respondent.getId(), lastBrowsedElement.getCreatedDate());
        previousBrowsedQuestionGroup.setLast(Boolean.TRUE);
        browsedElementRepository.save(previousBrowsedQuestionGroup);
        return previousBrowsedQuestionGroup.getQuestionGroup();
    }
}

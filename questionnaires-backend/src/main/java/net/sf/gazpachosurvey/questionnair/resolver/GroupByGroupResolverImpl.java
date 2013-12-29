package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.services.BrowsedElementService;
import net.sf.gazpachosurvey.services.QuestionGroupService;
import net.sf.gazpachosurvey.types.BrowsingAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("GroupByGroupResolver")
public class GroupByGroupResolverImpl implements QuestionnairElementResolver {

    private static final Logger logger = LoggerFactory.getLogger(GroupByGroupResolverImpl.class);

    private static final Integer INITIAL_POSITION = 0;

    @Autowired
    private BrowsedElementService browsedElementService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Override
    public QuestionGroup resolveFor(final Respondent respondent, final BrowsingAction action) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        int respondentId = respondent.getId();
        logger.debug("Finding QuestionGroup for respondent {} and surveyId = {}", respondentId, surveyId);

        BrowsedElement browsedElement = browsedElementService.findLast(respondentId);
        QuestionGroup questionGroup = null;
        BrowsedQuestionGroup lastBrowsedQuestionGroup = null;

        if (browsedElement == null) { // First time entering the survey
            questionGroup = questionGroupService.findOneByPositionInSurvey(surveyId, INITIAL_POSITION);
            lastBrowsedQuestionGroup = BrowsedQuestionGroup.with().respondent(respondent).questionGroup(questionGroup)
                    .last(Boolean.TRUE).build();
            browsedElementService.save(lastBrowsedQuestionGroup);
            return questionGroup;
        } else {
            Assert.isInstanceOf(BrowsedQuestionGroup.class, browsedElement);
            lastBrowsedQuestionGroup = (BrowsedQuestionGroup) browsedElement;
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
        browsedElementService.save(lastBrowsedQuestionGroup);
        return questionGroup;
    }

    private QuestionGroup findNextQuestionGroup(final Integer surveyId, final Respondent respondent,
            final BrowsedQuestionGroup lastBrowsedElement) {

        BrowsedElement nextBrowsedElement = browsedElementService.findNext(respondent.getId(),
                lastBrowsedElement.getCreatedDate());

        BrowsedQuestionGroup nextBrowsedQuestionGroup = null;
        QuestionGroup next = null;

        if (nextBrowsedElement == null) {
            Integer position = questionGroupService.findPositionInSurvey(lastBrowsedElement.getQuestionGroup().getId());
            next = questionGroupService.findOneByPositionInSurvey(surveyId, position + 1);

            // Mark next element as last browsed.
            nextBrowsedQuestionGroup = BrowsedQuestionGroup.with().respondent(respondent).questionGroup(next)
                    .last(Boolean.TRUE).build();
        } else {
            Assert.isInstanceOf(BrowsedQuestionGroup.class, nextBrowsedElement);
            nextBrowsedQuestionGroup = (BrowsedQuestionGroup) nextBrowsedElement;
            next = nextBrowsedQuestionGroup.getQuestionGroup();
            nextBrowsedQuestionGroup.setLast(Boolean.TRUE);
        }
        browsedElementService.save(nextBrowsedQuestionGroup);
        return next;
    }

    private QuestionGroup findPreviousQuestionGroup(final int surveyId, final Respondent respondent,
            final BrowsedQuestionGroup lastBrowsedElement) {
        BrowsedElement previousBrowsedElement = browsedElementService.findPrevious(respondent.getId(),
                lastBrowsedElement.getCreatedDate());
        Assert.isInstanceOf(BrowsedQuestionGroup.class, previousBrowsedElement);

        BrowsedQuestionGroup previousBrowsedQuestionGroup = (BrowsedQuestionGroup) previousBrowsedElement;
        previousBrowsedQuestionGroup.setLast(Boolean.TRUE);
        browsedElementService.save(previousBrowsedQuestionGroup);
        return previousBrowsedQuestionGroup.getQuestionGroup();
    }
}

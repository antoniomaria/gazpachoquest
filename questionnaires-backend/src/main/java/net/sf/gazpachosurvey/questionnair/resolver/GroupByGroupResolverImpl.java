package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
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

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(GroupByGroupResolverImpl.class);

    @Autowired
    private BrowsedElementService browsedElementService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Override
    public QuestionGroup resolveFor(final Questionnair questionnair, final BrowsingAction action) {
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} QuestionGroup for questionnair {}", action.toString(), questionnairId);

        BrowsedElement browsedElement = browsedElementService.findLast(questionnairId);
        QuestionGroup questionGroup = null;
        BrowsedQuestionGroup lastBrowsedQuestionGroup = null;

        if (browsedElement == null) { // First time entering the questionnairDefinition
            questionGroup = questionGroupService.findOneByPositionInSurvey(questionnairDefinitionId, INITIAL_POSITION);
            lastBrowsedQuestionGroup = BrowsedQuestionGroup.with().questionnair(questionnair)
                    .questionGroup(questionGroup).last(Boolean.TRUE).build();
            browsedElementService.save(lastBrowsedQuestionGroup);
            return questionGroup;
        } else {
            Assert.isInstanceOf(BrowsedQuestionGroup.class, browsedElement);
            lastBrowsedQuestionGroup = (BrowsedQuestionGroup) browsedElement;
        }

        switch (action) {
        case FORWARD:
            questionGroup = findNextQuestionGroup(questionnairDefinitionId, questionnair, lastBrowsedQuestionGroup);
            break;
        case BACKWARD:
            questionGroup = findPreviousQuestionGroup(questionnairDefinitionId, questionnair, lastBrowsedQuestionGroup);
            break;
        default:
            break;
        }
        lastBrowsedQuestionGroup.setLast(Boolean.FALSE);
        browsedElementService.save(lastBrowsedQuestionGroup);
        return questionGroup;
    }

    private QuestionGroup findNextQuestionGroup(final Integer questionnairDefinitionId,
            final Questionnair questionnair, final BrowsedQuestionGroup lastBrowsedElement) {

        BrowsedElement nextBrowsedElement = browsedElementService.findNext(questionnair.getId(),
                lastBrowsedElement.getCreatedDate());

        BrowsedQuestionGroup nextBrowsedQuestionGroup = null;
        QuestionGroup next = null;

        if (nextBrowsedElement == null) {
            Integer position = questionGroupService.findPositionInSurvey(lastBrowsedElement.getQuestionGroup().getId());
            next = questionGroupService.findOneByPositionInSurvey(questionnairDefinitionId, position + 1);

            // Mark next element as last browsed.
            nextBrowsedQuestionGroup = BrowsedQuestionGroup.with().questionnair(questionnair).questionGroup(next)
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

    private QuestionGroup findPreviousQuestionGroup(final int questionnairDefinitionId,
            final Questionnair questionnair, final BrowsedQuestionGroup lastBrowsedElement) {
        BrowsedElement previousBrowsedElement = browsedElementService.findPrevious(questionnair.getId(),
                lastBrowsedElement.getCreatedDate());
        Assert.isInstanceOf(BrowsedQuestionGroup.class, previousBrowsedElement);

        BrowsedQuestionGroup previousBrowsedQuestionGroup = (BrowsedQuestionGroup) previousBrowsedElement;
        previousBrowsedQuestionGroup.setLast(Boolean.TRUE);
        browsedElementService.save(previousBrowsedQuestionGroup);
        return previousBrowsedQuestionGroup.getQuestionGroup();
    }
}

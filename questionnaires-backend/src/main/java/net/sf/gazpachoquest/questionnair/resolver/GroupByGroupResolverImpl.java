/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.questionnair.resolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.BreadcrumbRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.types.BrowsingAction;

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
    private BreadcrumbRepository breadcrumbRepository;

    @Autowired
    private QuestionGroupRepository questionGroupService;

    @Autowired
    private QuestionnairService questionnairService;

    @Override
    public QuestionGroup resolveFor(final Questionnair questionnair, final BrowsingAction action) {
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} QuestionGroup for questionnair {}", action.toString(), questionnairId);

        Breadcrumb breadcrumb = breadcrumbRepository.findLast(questionnairId);
        QuestionGroup questionGroup = null;
        QuestionGroupBreadcrumb lastBreadcrumb = null;

        Boolean groupsRandomizationEnabled = questionnairDefinition.isRandomizationEnabled();

        if (breadcrumb == null) { // First time entering the
                                  // questionnairDefinition
            List<Breadcrumb> breadcrumbs = makeBreadcrumbs(questionnair);
            for (Breadcrumb newBreadcrumb : breadcrumbs) {
                questionnair.addBreadcrumb(newBreadcrumb);
                questionnairService.save(questionnair);
            }
            return questionGroup;
        } else {
            if (breadcrumb instanceof QuestionGroupBreadcrumb) {
                lastBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
            } else {
                List<Breadcrumb> breadcrumbs = breadcrumbRepository.findByExample(
                        Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
                        new SearchParameters());
                breadcrumbRepository.deleteInBatch(breadcrumbs);
                questionGroup = findFirstQuestionGroup(questionnairDefinitionId);
                lastBreadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup)
                        .last(Boolean.TRUE).build();
                breadcrumbRepository.save(lastBreadcrumb);
                return questionGroup;
            }
        }

        if (BrowsingAction.ENTERING.equals(action)) {
            questionGroup = lastBreadcrumb.getQuestionGroup();
        } else {
            if (BrowsingAction.FORWARD.equals(action)) {
                questionGroup = findNextQuestionGroup(questionnairDefinitionId, questionnair, lastBreadcrumb);
            } else {// BACKWARD
                questionGroup = findPreviousQuestionGroup(questionnairDefinitionId, questionnair, lastBreadcrumb);
            }
            if (questionGroup != null) { // Prevent that questions are still in
                                         // range.
                lastBreadcrumb.setLast(Boolean.FALSE);
                breadcrumbRepository.save(lastBreadcrumb);
            }
        }
        return questionGroup;
    }

    private List<Breadcrumb> makeBreadcrumbs(Questionnair questionnair) {
        List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        Integer questionnairDefinitionId = questionnairDefinition.getId();
        Boolean groupsRandomizationEnabled = questionnairDefinition.isRandomizationEnabled();

        if (groupsRandomizationEnabled) {
            List<QuestionGroup> questionGroups = questionGroupService.findByExample(
                    QuestionGroup.with()
                            .questionnairDefinition(QuestionnairDefinition.with().id(questionnairDefinitionId).build())
                            .build(), new SearchParameters());
            
            Collections.shuffle(questionGroups);
            for (QuestionGroup questionGroup : questionGroups) {
                if (questionGroup.isRandomizationEnabled()){
                    System.out.println("randomize questions");
                }else{
                    System.out.println("questions in order");
                }
            }
        } else {
            QuestionGroup questionGroup = findFirstQuestionGroup(questionnairDefinitionId);
            QuestionGroupBreadcrumb lastBreadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair)
                    .questionGroup(questionGroup).last(Boolean.TRUE).build();
            breadcrumbs.add(lastBreadcrumb);
        }

        return breadcrumbs;
    }

    private QuestionGroup findFirstQuestionGroup(int questionnairDefinitionId) {
        return questionGroupService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                INITIAL_POSITION);
    }

    private QuestionGroup findNextQuestionGroup(final Integer questionnairDefinitionId,
            final Questionnair questionnair, final QuestionGroupBreadcrumb lastBrowsedElement) {

        Breadcrumb nextBrowsedElement = breadcrumbRepository.findNext(questionnair.getId(),
                lastBrowsedElement.getCreatedDate());

        QuestionGroupBreadcrumb nextBrowsedQuestionGroup = null;
        QuestionGroup next = null;

        if (nextBrowsedElement == null) {
            Integer position = questionGroupService.positionInQuestionnairDefinition(lastBrowsedElement
                    .getQuestionGroup().getId());
            next = questionGroupService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                    position + 1);
            if (next == null) { // The respondent has reached the last question
                                // group
                return next;
            }
            // Mark next element as last browsed.
            nextBrowsedQuestionGroup = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(next)
                    .last(Boolean.TRUE).build();
        } else {
            Assert.isInstanceOf(QuestionGroupBreadcrumb.class, nextBrowsedElement);
            nextBrowsedQuestionGroup = (QuestionGroupBreadcrumb) nextBrowsedElement;
            next = nextBrowsedQuestionGroup.getQuestionGroup();
            nextBrowsedQuestionGroup.setLast(Boolean.TRUE);
        }
        breadcrumbRepository.save(nextBrowsedQuestionGroup);
        return next;
    }

    private QuestionGroup findPreviousQuestionGroup(final int questionnairDefinitionId,
            final Questionnair questionnair, final QuestionGroupBreadcrumb lastBreadcrumb) {
        Breadcrumb previousBreadcrumb = breadcrumbRepository.findPrevious(questionnair.getId(),
                lastBreadcrumb.getCreatedDate());
        if (previousBreadcrumb == null) {
            return null;
        }
        Assert.isInstanceOf(QuestionGroupBreadcrumb.class, previousBreadcrumb);

        QuestionGroupBreadcrumb previousBrowsedQuestionGroup = (QuestionGroupBreadcrumb) previousBreadcrumb;
        previousBrowsedQuestionGroup.setLast(Boolean.TRUE);
        breadcrumbRepository.save(previousBrowsedQuestionGroup);
        return previousBrowsedQuestionGroup.getQuestionGroup();
    }
}

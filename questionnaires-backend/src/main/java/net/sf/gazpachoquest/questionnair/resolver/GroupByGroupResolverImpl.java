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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.BreadcrumbRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.services.QuestionService;
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
    private QuestionService questionService;

    @Autowired
    private QuestionnairService questionnairService;

    @Override
    public QuestionGroup resolveFor(final Questionnair questionnair, final BrowsingAction action) {
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} QuestionGroup for questionnair {}", action.toString(), questionnairId);

        List<Object[]> result = breadcrumbRepository.findLastAndPosition(questionnairId);
        Breadcrumb breadcrumb = null;
        QuestionGroupBreadcrumb lastBreadcrumb = null;

        List<QuestionGroupBreadcrumb> breadcrumbs = null;
        Integer lastBreadcrumbPosition = null;
        if (result.isEmpty()) { // First time entering the
                                // questionnairDefinition
            breadcrumbs = makeBreadcrumbs(questionnair);
            leaveBreakcrumbs(questionnair, breadcrumbs);
            lastBreadcrumb = breadcrumbs.get(0);
        } else {
            Assert.isTrue(result.size() == 1, "Unexpected result. Only one last element allowed per questionnair");
            lastBreadcrumbPosition = (Integer) result.get(0)[1];
            breadcrumb = (Breadcrumb) result.get(0)[0];
            if (breadcrumb instanceof QuestionGroupBreadcrumb) {
                lastBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
            } else {
                List<Breadcrumb> oldBreadcrumbs = breadcrumbRepository.findByExample(Breadcrumb.withProps()
                        .questionnair(Questionnair.with().id(questionnairId).build()).build(), new SearchParameters());
                breadcrumbRepository.deleteInBatch(oldBreadcrumbs);

                breadcrumbs = makeBreadcrumbs(questionnair);
                leaveBreakcrumbs(questionnair, breadcrumbs);
                lastBreadcrumb = breadcrumbs.get(0);
            }
        }
        QuestionGroupBreadcrumb nextBreadcrumb = null;

        if (BrowsingAction.ENTERING.equals(action)) {
            nextBreadcrumb = lastBreadcrumb;
        } else {
            if (BrowsingAction.NEXT.equals(action)) {
                nextBreadcrumb = findNextBreadcrumb(questionnairDefinitionId, questionnair, lastBreadcrumb,
                        lastBreadcrumbPosition);
            } else {// PREVIOUS
                nextBreadcrumb = findPreviousBreadcrumb(questionnairDefinitionId, questionnair, lastBreadcrumb,
                        lastBreadcrumbPosition);
            }
            // Prevent that questiongroups are still in range.
            if (nextBreadcrumb != null) {
                lastBreadcrumb.setLast(Boolean.FALSE);
                nextBreadcrumb.setLast(Boolean.TRUE);
                leaveBreakcrumbs(questionnair, Arrays.asList(lastBreadcrumb, nextBreadcrumb));
            } else {
                nextBreadcrumb = lastBreadcrumb;
            }
        }
        return extractFrom(nextBreadcrumb);
    }

    private QuestionGroup extractFrom(QuestionGroupBreadcrumb breadcrumb) {
        QuestionGroup refered = breadcrumb.getQuestionGroup();
        QuestionGroup questionGroup = QuestionGroup.with().language(refered.getLanguage())
                .languageSettings(refered.getLanguageSettings()).build();

        for (QuestionBreadcrumb questionBreadcrumb : breadcrumb.getBreadcrumbs()) {
            questionGroup.addQuestion(questionBreadcrumb.getQuestion());
        }
        return questionGroup;
    }

    private void leaveBreakcrumbs(final Questionnair questionnair, List<QuestionGroupBreadcrumb> breadcrumbs) {
        for (Breadcrumb newBreadcrumb : breadcrumbs) {
            questionnair.addBreadcrumb(newBreadcrumb);
            questionnairService.save(questionnair);
        }
    }

    private List<QuestionGroupBreadcrumb> makeBreadcrumbs(Questionnair questionnair) {
        List<QuestionGroupBreadcrumb> breadcrumbs = new ArrayList<QuestionGroupBreadcrumb>();
        QuestionGroupBreadcrumb breadcrumb = null;
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
                breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup)
                        .last(Boolean.FALSE).build();
                breadcrumbs.add(breadcrumb);
            }
        } else {
            QuestionGroup questionGroup = findFirstQuestionGroup(questionnairDefinitionId);
            breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup).build();
            breadcrumbs.add(breadcrumb);
        }

        populatedQuestionsBreadcrumbs(breadcrumbs);
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    private void populatedQuestionsBreadcrumbs(List<QuestionGroupBreadcrumb> breadcrumbs) {
        for (QuestionGroupBreadcrumb questionGroupBreadcrumb : breadcrumbs) {
            QuestionGroup questionGroup = questionGroupBreadcrumb.getQuestionGroup();

            List<Question> questions = findQuestions(questionGroup);

            for (Question question : questions) {
                questionGroupBreadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).last(Boolean.FALSE)
                        .build());
            }
        }
    }

    private List<Question> findQuestions(QuestionGroup questionGroup) {
        List<Question> questions;
        if (questionGroup.isRandomizationEnabled()) {
            questions = questionService.findByExample(
                    Question.with().questionGroup(QuestionGroup.with().id(questionGroup.getId()).build()).build(),
                    new SearchParameters());
            Collections.shuffle(questions);
        } else {
            questions = questionService.findByQuestionGroupId(questionGroup.getId());
        }
        return questions;
    }

    private QuestionGroup findFirstQuestionGroup(int questionnairDefinitionId) {
        return questionGroupService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                INITIAL_POSITION);
    }

    private QuestionGroupBreadcrumb findNextBreadcrumb(final Integer questionnairDefinitionId,
            final Questionnair questionnair, final QuestionGroupBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {

        Breadcrumb breadcrumb = breadcrumbRepository.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition + 1);

        QuestionGroupBreadcrumb nextBreadcrumb = null;

        if (breadcrumb == null) {
            Integer position = questionGroupService.positionInQuestionnairDefinition(lastBreadcrumb.getQuestionGroup()
                    .getId());
            QuestionGroup next = questionGroupService.findOneByPositionInQuestionnairDefinition(
                    questionnairDefinitionId, position + 1);
            // The respondent has reached the last question group
            if (next == null) {
                logger.warn("Page out of range. Returning last page");
                return null;
            }
            nextBreadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(next).build();
            populatedQuestionsBreadcrumbs(Arrays.asList(nextBreadcrumb));
        } else {
            Assert.isInstanceOf(QuestionGroupBreadcrumb.class, breadcrumb);
            nextBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
        }
        return nextBreadcrumb;
    }

    private QuestionGroupBreadcrumb findPreviousBreadcrumb(final Integer questionnairDefinitionId,
            final Questionnair questionnair, final QuestionGroupBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }
        Breadcrumb breadcrumb = breadcrumbRepository.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition - 1);

        Assert.isInstanceOf(QuestionGroupBreadcrumb.class, breadcrumb);

        QuestionGroupBreadcrumb previousBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
        return previousBreadcrumb;
    }

}

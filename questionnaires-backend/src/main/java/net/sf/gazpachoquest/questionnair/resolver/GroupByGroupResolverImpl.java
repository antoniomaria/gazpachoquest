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
import net.sf.gazpachoquest.questionnair.support.PageMetadataCreator;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("GroupByGroupResolver")
public class GroupByGroupResolverImpl extends AbstractResolver<QuestionGroupBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(GroupByGroupResolverImpl.class);

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private PageMetadataCreator metadataCreator;

    /*-
     @Override
     public PageStructure resolveNextPage(final Questionnair questionnair, final NavigationAction action) {
     Questionnair fetchedQuestionnair = questionnairService.findOne(questionnair.getId());
     QuestionnairDefinition questionnairDefinition = fetchedQuestionnair.getQuestionnairDefinition();
     int questionnairId = questionnair.getId();
     logger.debug("Finding {} QuestionGroup for questionnair {}", action.toString(), questionnairId);

     List<Object[]> result = breadcrumbService.findLastAndPosition(questionnairId);
     Breadcrumb breadcrumb = null;
     Breadcrumb lastBreadcrumb = null;

     List<Breadcrumb> breadcrumbs = null;
     Integer lastBreadcrumbPosition = null;
     if (result.isEmpty()) { // First time entering the
     // questionnairDefinition
     breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
     leaveBreakcrumbs(questionnair, breadcrumbs);
     lastBreadcrumb = breadcrumbs.get(0);
     } else {
     Assert.isTrue(result.size() == 1, "Unexpected result. Only one last element allowed per questionnair");
     lastBreadcrumbPosition = (Integer) result.get(0)[1];
     breadcrumb = (Breadcrumb) result.get(0)[0];
     if (breadcrumb instanceof QuestionGroupBreadcrumb) {
     lastBreadcrumb = breadcrumb;
     } else {
     breadcrumbService.deleteByExample(
     Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
     new SearchParameters());

     breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
     leaveBreakcrumbs(questionnair, breadcrumbs);
     lastBreadcrumb = breadcrumbs.get(0);
     }
     }
     Breadcrumb nextBreadcrumb = null;

     if (NavigationAction.ENTERING.equals(action)) {
     nextBreadcrumb = lastBreadcrumb;
     } else {
     if (!RandomizationStrategy.QUESTIONS_RANDOMIZATION
     .equals(questionnairDefinition.getRandomizationStrategy())) {
     // QuestionGroup is not applicable when questions are
     // randomized.
     // Assert.isTrue(lastBreadcrumb.getQuestionGroup() != null);
     }
     if (NavigationAction.NEXT.equals(action)) {
     nextBreadcrumb = findNextBreadcrumb(questionnairDefinition, questionnair, lastBreadcrumb,
     lastBreadcrumbPosition);
     } else {// PREVIOUS
     nextBreadcrumb = findPreviousBreadcrumb(questionnairDefinition, questionnair, lastBreadcrumb,
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
     return createPageStructure(questionnairDefinition.getRandomizationStrategy(), nextBreadcrumb);
     }

     @Override
     private PageStructure createPageStructure(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb) {
     PageStructure nextPage = new PageStructure();
     nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumb));
     QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
     for (QuestionBreadcrumb questionBreadcrumb : questionGroupBreadcrumb.getBreadcrumbs()) {
     nextPage.addQuestionsId(questionBreadcrumb.getQuestion().getId());
     }
     return nextPage;
     }

     @Override
     private void leaveBreakcrumbs(final Questionnair questionnair, List<Breadcrumb> breadcrumbs) {
     for (Breadcrumb newBreadcrumb : breadcrumbs) {
     questionnair.addBreadcrumb(newBreadcrumb);
     }
     questionnairService.save(questionnair);
     }

    


     @Override
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
     */
    private QuestionGroup findFirstQuestionGroup(int questionnairDefinitionId) {
        return questionGroupService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                INITIAL_POSITION);
    }

    private void populateQuestionsBreadcrumbs(List<Breadcrumb> breadcrumbs) {

        for (Breadcrumb breadcrumb : breadcrumbs) {
            QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;

            QuestionGroup questionGroup = questionGroupBreadcrumb.getQuestionGroup();

            List<Question> questions = findQuestions(questionGroup);

            for (Question question : questions) {
                questionGroupBreadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).last(Boolean.FALSE)
                        .build());
            }
        }
    }

    @Override
    protected List<Breadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition, Questionnair questionnair) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        QuestionGroupBreadcrumb breadcrumb = null;
        Integer questionnairDefinitionId = questionnairDefinition.getId();
        RandomizationStrategy randomizationStrategy = questionnairDefinition.getRandomizationStrategy();
        if (RandomizationStrategy.GROUPS_RANDOMIZATION.equals(randomizationStrategy)) {
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
            populateQuestionsBreadcrumbs(breadcrumbs);
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Question> questions = questionnairDefinitionService.getQuestions(questionnairDefinitionId);
            Collections.shuffle(questions);
            Integer questionPerPage = questionnairDefinition.getQuestionsPerPage();
            int questionIdx = 0;
            for (Question question : questions) {
                if (questionIdx % questionPerPage == 0) {
                    breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).last(Boolean.FALSE).build();
                    breadcrumbs.add(breadcrumb);
                }
                breadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).build());
                questionIdx++;
            }

        } else {
            QuestionGroup questionGroup = findFirstQuestionGroup(questionnairDefinitionId);
            breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup).build();
            breadcrumbs.add(breadcrumb);
            populateQuestionsBreadcrumbs(breadcrumbs);
        }
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    @Override
    protected Breadcrumb findNextBreadcrumb(final QuestionnairDefinition questionnairDefinition,
            final Questionnair questionnair, final Breadcrumb lastBreadcrumb, final Integer lastBreadcrumbPosition) {

        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition + 1);

        Breadcrumb nextBreadcrumb = null;

        // There is no real questionGroup when QuestionsRandomization is enabled
        if (breadcrumb == null
                && !questionnairDefinition.getRandomizationStrategy().equals(
                        RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {

            Assert.isInstanceOf(QuestionGroupBreadcrumb.class, lastBreadcrumb);

            Integer position = questionGroupService
                    .positionInQuestionnairDefinition(((QuestionGroupBreadcrumb) lastBreadcrumb).getQuestionGroup()
                            .getId());
            QuestionGroup next = questionGroupService.findOneByPositionInQuestionnairDefinition(
                    questionnairDefinition.getId(), position + 1);
            // The respondent has reached the last question group
            if (next == null) {
                logger.warn("Page out of range. Returning last page");
                return null;
            }
            nextBreadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(next).build();
            populateQuestionsBreadcrumbs(Arrays.asList(nextBreadcrumb));
        } else {
            nextBreadcrumb = breadcrumb;
        }
        return nextBreadcrumb;
    }

    @Override
    protected Breadcrumb findPreviousBreadcrumb(final QuestionnairDefinition questionnairDefinition,
            final Questionnair questionnair, final Breadcrumb lastBreadcrumb, final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }

        return breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(), lastBreadcrumbPosition - 1);
    }
}

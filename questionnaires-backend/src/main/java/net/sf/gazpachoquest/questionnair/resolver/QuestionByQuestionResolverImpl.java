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
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.questionnair.support.PageMetadataCreator;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("QuestionByQuestionResolver")
public class QuestionByQuestionResolverImpl implements PageResolver {
    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(QuestionByQuestionResolverImpl.class);

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

    @Override
    public PageStructure resolveNextPage(Questionnair questionnair, NavigationAction action) {
        Questionnair fetchedQuestionnair = questionnairService.findOne(questionnair.getId());
        QuestionnairDefinition questionnairDefinition = fetchedQuestionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} QuestionGroup for questionnair {}", action.toString(), questionnairId);

        List<Object[]> result = breadcrumbService.findLastAndPosition(questionnairId);
        Breadcrumb breadcrumb = null;
        QuestionBreadcrumb lastBreadcrumb = null;

        List<Breadcrumb> breadcrumbs = null;
        Integer lastBreadcrumbPosition = null;

        if (result.isEmpty()) { // First time entering the
            // questionnairDefinition
            breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
            leaveBreakcrumbs(questionnair, breadcrumbs);
            lastBreadcrumb = (QuestionBreadcrumb) breadcrumbs.get(0);
        } else {
            Assert.isTrue(result.size() == 1, "Unexpected result. Only one last element allowed per questionnair");
            lastBreadcrumbPosition = (Integer) result.get(0)[1];
            breadcrumb = (Breadcrumb) result.get(0)[0];
            if (breadcrumb instanceof QuestionBreadcrumb) {
                lastBreadcrumb = (QuestionBreadcrumb) breadcrumb;
            } else {
                breadcrumbService.deleteByExample(
                        Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
                        new SearchParameters());

                breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
                leaveBreakcrumbs(questionnair, breadcrumbs);
                lastBreadcrumb = (QuestionBreadcrumb) breadcrumbs.get(0);
            }
        }
        Breadcrumb nextBreadcrumb = null;

        if (NavigationAction.ENTERING.equals(action)) {
            nextBreadcrumb = lastBreadcrumb;
        } else {
            if (NavigationAction.NEXT.equals(action)) {
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

        return createPageStructure(questionnairDefinition.getRandomizationStrategy(), nextBreadcrumb);
    }

    private PageStructure createPageStructure(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb) {
        PageStructure nextPage = new PageStructure();
        nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumb));

        nextPage.addQuestionsId(((QuestionBreadcrumb) breadcrumb).getQuestion().getId());
        return nextPage;
    }

    private List<Breadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition, Questionnair questionnair) {
        List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
        QuestionBreadcrumb breadcrumb = null;
        Integer questionnairDefinitionId = questionnairDefinition.getId();
        RandomizationStrategy randomizationStrategy = questionnairDefinition.getRandomizationStrategy();
        if (RandomizationStrategy.GROUPS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<QuestionGroup> questionGroups = questionGroupService.findByExample(
                    QuestionGroup.with()
                            .questionnairDefinition(QuestionnairDefinition.with().id(questionnairDefinitionId).build())
                            .build(), new SearchParameters());
            Collections.shuffle(questionGroups);
            for (QuestionGroup questionGroup : questionGroups) {
                List<Question> questions = findQuestions(questionGroup);
                for (Question question : questions) {
                    breadcrumb = QuestionBreadcrumb.with().questionnair(questionnair).last(Boolean.FALSE)
                            .question(question).build();
                    breadcrumbs.add(breadcrumb);
                }
            }
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Question> questions = questionnairDefinitionService.getQuestions(questionnairDefinitionId);
            Collections.shuffle(questions);
            for (Question question : questions) {
                breadcrumb = QuestionBreadcrumb.with().questionnair(questionnair).last(Boolean.FALSE)
                        .question(question).build();
                breadcrumbs.add(breadcrumb);
            }
        } else {
            Question question = findFirstQuestion(questionnairDefinitionId);
            breadcrumb = QuestionBreadcrumb.with().questionnair(questionnair).last(Boolean.FALSE).question(question)
                    .build();
            breadcrumbs.add(breadcrumb);
        }
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    private Breadcrumb findNextBreadcrumb(final Integer questionnairDefinitionId, final Questionnair questionnair,
            final QuestionBreadcrumb lastBreadcrumb, final Integer lastBreadcrumbPosition) {

        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition + 1);

        QuestionBreadcrumb nextBreadcrumb = null;

        if (breadcrumb == null) {
            QuestionGroup lastQuestionGroup = lastBreadcrumb.getQuestion().getQuestionGroup();

            Integer position = questionService.findPositionInQuestionGroup(lastBreadcrumb.getQuestion().getId());
            long questionsCount = questionGroupService.questionsCount(lastQuestionGroup.getId());
            Question next = null;
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupService.positionInQuestionnairDefinition(lastQuestionGroup
                        .getId());
                QuestionGroup nextQuestionGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                        questionnairDefinitionId, questionGroupPosition + 1);

                if (nextQuestionGroup == null) { // TODO handle exceptions
                    return null;
                }
                next = questionService.findOneByPositionInQuestionGroup(nextQuestionGroup.getId(), INITIAL_POSITION);
            }
            // Mark next element as last browsed.
            nextBreadcrumb = QuestionBreadcrumb.with().questionnair(questionnair).question(next).build();
        } else {
            Assert.isInstanceOf(QuestionBreadcrumb.class, breadcrumb);
            nextBreadcrumb = (QuestionBreadcrumb) breadcrumb;
        }

        return nextBreadcrumb;
    }

    private Breadcrumb findPreviousBreadcrumb(final int questionnairDefinitionId, final Questionnair questionnair,
            final QuestionBreadcrumb lastBreadcrumb, final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }
        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition - 1);

        Assert.isInstanceOf(QuestionBreadcrumb.class, breadcrumb);

        // QuestionBreadcrumb previousBreadcrumb = (QuestionGroupBreadcrumb)
        // breadcrumb;
        return breadcrumb;
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

    private void leaveBreakcrumbs(final Questionnair questionnair, List<Breadcrumb> breadcrumbs) {
        for (Breadcrumb newBreadcrumb : breadcrumbs) {
            questionnair.addBreadcrumb(newBreadcrumb);
        }
        questionnairService.save(questionnair);
    }

    private Question findFirstQuestion(int questionnairDefinitionId) {
        QuestionGroup initialGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                questionnairDefinitionId, INITIAL_POSITION);
        return questionService.findOneByPositionInQuestionGroup(initialGroup.getId(), INITIAL_POSITION);
    }

    /*-
    @Override
    public Question resolveFor(final Questionnair questionnair, final NavigationAction action) {
        QuestionnairDefinition questionnairDefinition = questionnair.getQuestionnairDefinition();
        int questionnairDefinitionId = questionnairDefinition.getId();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} Question for questionnair {}", action.toString(), questionnairId);

        Breadcrumb breadcrumb = browsedElementService.findLast(questionnairId);
        QuestionBreadcrumb lastBrowsedQuestion = null;
        Question question = null;

        if (breadcrumb == null) { // First time entering the
                                  // questionnairDefinition
            question = findFirstQuestion(questionnairDefinitionId);
            lastBrowsedQuestion = QuestionBreadcrumb.with().questionnair(questionnair).question(question)
                    .last(Boolean.TRUE).build();
            browsedElementService.save(lastBrowsedQuestion);
            return question;
        } else {
            if (breadcrumb instanceof QuestionBreadcrumb) {
                lastBrowsedQuestion = (QuestionBreadcrumb) breadcrumb;
            } else {
                List<Breadcrumb> breadcrumbs = browsedElementService.findByExample(
                        Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
                        new SearchParameters());
                browsedElementService.deleteInBatch(breadcrumbs);

                question = findFirstQuestion(questionnairDefinitionId);
                lastBrowsedQuestion = QuestionBreadcrumb.with().questionnair(questionnair).question(question)
                        .last(Boolean.TRUE).build();
                browsedElementService.save(lastBrowsedQuestion);
            }
        }

        if (NavigationAction.ENTERING.equals(action)) {
            question = lastBrowsedQuestion.getQuestion();
        } else {
            if (NavigationAction.NEXT.equals(action)) {
                question = findNextQuestion(questionnairDefinitionId, questionnair, lastBrowsedQuestion);
            } else {// PREVIOUS
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
            final QuestionBreadcrumb lastBrowsedQuestion) {

        Breadcrumb nextBrowsedElement = browsedElementService.findNext(respondent.getId(),
                lastBrowsedQuestion.getCreatedDate());
        QuestionBreadcrumb nextBrowsedQuestion = null;
        Question next = null;

        if (nextBrowsedElement == null) {
            QuestionGroup lastQuestionGroup = lastBrowsedQuestion.getQuestion().getQuestionGroup();

            Integer position = questionService.findPositionInQuestionGroup(lastBrowsedQuestion.getQuestion().getId());

            long questionsCount = questionsCount(lastQuestionGroup.getId());
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupService.positionInQuestionnairDefinition(lastQuestionGroup
                        .getId());
                QuestionGroup nextQuestionGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                        surveyId, questionGroupPosition + 1);

                if (nextQuestionGroup == null) { // TODO handle exceptions
                    return null;
                }
                next = questionService.findOneByPositionInQuestionGroup(nextQuestionGroup.getId(), INITIAL_POSITION);
            }
            // Mark next element as last browsed.
            nextBrowsedQuestion = QuestionBreadcrumb.with().questionnair(respondent).question(next).last(Boolean.TRUE)
                    .build();
        } else {
            Assert.isInstanceOf(QuestionBreadcrumb.class, nextBrowsedElement);
            nextBrowsedQuestion = (QuestionBreadcrumb) nextBrowsedElement;
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
            final QuestionBreadcrumb lastBrowsedElement) {
        Breadcrumb previousBrowsedElement = browsedElementService.findPrevious(respondent.getId(),
                lastBrowsedElement.getCreatedDate());
        if (previousBrowsedElement == null) {
            return null;
        }
        Assert.isInstanceOf(QuestionBreadcrumb.class, previousBrowsedElement);

        QuestionBreadcrumb previousBrowsedQuestion = (QuestionBreadcrumb) previousBrowsedElement;
        previousBrowsedQuestion.setLast(Boolean.TRUE);
        browsedElementService.save(previousBrowsedQuestion);
        return previousBrowsedQuestion.getQuestion();
    }
     */

}

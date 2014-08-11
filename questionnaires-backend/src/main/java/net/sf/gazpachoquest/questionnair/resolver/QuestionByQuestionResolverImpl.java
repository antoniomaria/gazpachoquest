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
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("QuestionByQuestionResolver")
public class QuestionByQuestionResolverImpl extends AbstractResolver<QuestionBreadcrumb> implements PageResolver {
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
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb) {
        PageStructure nextPage = new PageStructure();
        nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumb));

        nextPage.addQuestionsId(((QuestionBreadcrumb) breadcrumb).getQuestion().getId());
        return nextPage;
    }

    @Override
    protected List<Breadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition, Questionnair questionnair) {
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

    @Override
    protected Breadcrumb findNextBreadcrumb(QuestionnairDefinition questionnairDefinition, Questionnair questionnair,
            Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {

        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition + 1);

        QuestionBreadcrumb nextBreadcrumb = null;

        if (breadcrumb == null) {
            Assert.isInstanceOf(QuestionBreadcrumb.class, lastBreadcrumb);

            QuestionGroup lastQuestionGroup = ((QuestionBreadcrumb) lastBreadcrumb).getQuestion().getQuestionGroup();

            Integer position = questionService.findPositionInQuestionGroup(((QuestionBreadcrumb) lastBreadcrumb)
                    .getQuestion().getId());
            long questionsCount = questionGroupService.questionsCount(lastQuestionGroup.getId());
            Question next = null;
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInQuestionGroup(lastQuestionGroup.getId(), position + 1);
            } else {
                Integer questionGroupPosition = questionGroupService.positionInQuestionnairDefinition(lastQuestionGroup
                        .getId());
                QuestionGroup nextQuestionGroup = questionGroupService.findOneByPositionInQuestionnairDefinition(
                        questionnairDefinition.getId(), questionGroupPosition + 1);

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

    @Override
    protected Breadcrumb findPreviousBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }
        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnairIdAndPosition(questionnair.getId(),
                lastBreadcrumbPosition - 1);
        Assert.isInstanceOf(QuestionBreadcrumb.class, breadcrumb);
        return breadcrumb;
    }

    @Override
    protected List<Question> findQuestions(QuestionGroup questionGroup) {
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

    @Override
    protected void leaveBreakcrumbs(final Questionnair questionnair, List<Breadcrumb> breadcrumbs) {
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

}

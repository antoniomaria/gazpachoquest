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
import net.sf.gazpachoquest.domain.core.QuestionGroup.Builder;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("GroupByGroupResolver")
public class GroupByGroupResolver extends AbstractResolver<QuestionGroupBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(GroupByGroupResolver.class);

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    protected GroupByGroupResolver() {
        super(RenderingMode.GROUP_BY_GROUP);
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
                        .last(Boolean.FALSE).renderingMode(RenderingMode.GROUP_BY_GROUP).build();
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
                    breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).last(Boolean.FALSE)
                            .renderingMode(RenderingMode.GROUP_BY_GROUP).build();
                    breadcrumbs.add(breadcrumb);
                }
                breadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).build());
                questionIdx++;
            }

        } else {
            QuestionGroup questionGroup = findFirstQuestionGroup(questionnairDefinitionId);
            breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup)
                    .renderingMode(RenderingMode.GROUP_BY_GROUP).build();
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
            nextBreadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(next)
                    .renderingMode(RenderingMode.GROUP_BY_GROUP).build();
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

    private QuestionGroup findFirstQuestionGroup(int questionnairDefinitionId) {
        return questionGroupService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                INITIAL_POSITION);
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<Breadcrumb> breadcrumbs) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs);
        Breadcrumb active = breadcrumbs.get(0);

        QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) active;
        Builder builder = QuestionGroup.with();
        if (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
            builder.id(questionGroupBreadcrumb.getQuestionGroup().getId());
        }
        QuestionGroup questionGroup = builder.build();
        for (QuestionBreadcrumb questionBreadcrumb : questionGroupBreadcrumb.getBreadcrumbs()) {
            questionGroup.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId()).build());
        }
        nextPage.addQuestionGroup(questionGroup);
        return nextPage;
    }
}

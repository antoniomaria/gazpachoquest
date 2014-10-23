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
package net.sf.gazpachoquest.questionnaire.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.el.ELException;
import javax.el.ExpressionFactory;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.Section.Builder;
import net.sf.gazpachoquest.domain.core.SectionBreadcrumb;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

@Component("SectionBySectionRelevanceAwareResolver")
public class SectionBySectionRelevanceAwareResolver extends AbstractResolver<SectionBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(SectionBySectionRelevanceAwareResolver.class);

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private SectionService sectionService;

    private ExpressionFactory elFactory = new ExpressionFactoryImpl();

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    protected SectionBySectionRelevanceAwareResolver() {
        super(RenderingMode.SECTION_BY_SECTION);
    }

    @Override
    protected List<SectionBreadcrumb> makeBreadcrumbs(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire) {
        List<SectionBreadcrumb> breadcrumbs = new ArrayList<>();
        SectionBreadcrumb breadcrumb = null;
        Integer questionnairDefinitionId = questionnaireDefinition.getId();

        Section section = findFirstSection(questionnairDefinitionId);
        breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(section)
                .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
        breadcrumbs.add(breadcrumb);
        populateQuestionsBreadcrumbs(breadcrumbs, QUESTION_NUMBER_START_COUNTER);
        // Store questions displayed number in order to generate the question
        // numbers.
        breadcrumb.setQuestionsDisplayedCount(breadcrumb.getQuestionsBreadcrumbCount());
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    @Override
    protected SectionBreadcrumb findNextBreadcrumb(final QuestionnaireDefinition questionnaireDefinition,
            final Questionnaire questionnaire, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {

        SectionBreadcrumb nextBreadcrumb = null;

        Integer position = sectionService.positionInQuestionnaireDefinition(lastBreadcrumb.getSection().getId());
        boolean found = false;
        Section next = null;
        Map<String, Object> answers = questionnaireAnswersService.findByQuestionnaire(questionnaire);

        do {
            position++;
            next = sectionService.findOneByPositionInQuestionnaireDefinition(questionnaireDefinition.getId(), position);
            if (next == null) {
                break;
            }
            found = isRevealed(next, answers);
        } while (!found);

        // The respondent has reached the last question group
        if (next == null) {
            logger.warn("Page out of range. Returning last page");
            return null;
        }
        nextBreadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(next)
                .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
        Integer questionsDisplayedCount = lastBreadcrumb.getQuestionsDisplayedCount();
        populateQuestionsBreadcrumbs(Arrays.asList(nextBreadcrumb), questionsDisplayedCount + 1);
        nextBreadcrumb.setQuestionsDisplayedCount(questionsDisplayedCount
                + nextBreadcrumb.getQuestionsBreadcrumbCount());
        return nextBreadcrumb;
    }

    private boolean isRevealed(Section next, Map<String, Object> answers) {
        String relevance = next.getRelevance();
        if (StringUtils.isBlank(relevance)) {
            return true;
        }
        SimpleContext context = new SimpleContext();
        for (Entry<String, Object> answer : answers.entrySet()) {
            String code = answer.getKey();
            Object value = answer.getValue();
            if (value != null) {
                context.setVariable(code, elFactory.createValueExpression(value, value.getClass()));
            }
        }
        Boolean revealed = false;
        try {
            // Evaluate the condition
            revealed = (Boolean) elFactory.createValueExpression(context, relevance, Boolean.class).getValue(context);
        } catch (ELException e) {
            logger.warn("Errors found in evaluating the relevance condition", e);
        }
        return revealed;
    }

    @Override
    protected SectionBreadcrumb findPreviousBreadcrumb(final QuestionnaireDefinition questionnaireDefinition,
            final Questionnaire questionnaire, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }
        SectionBreadcrumb previous = (SectionBreadcrumb) breadcrumbService.findByQuestionnaireIdAndPosition(
                questionnaire.getId(), lastBreadcrumbPosition - 1);
        return previous;
    }

    private Section findFirstSection(int questionnairDefinitionId) {
        // It assumes that the first section is always displayed
        return sectionService.findOneByPositionInQuestionnaireDefinition(questionnairDefinitionId, INITIAL_POSITION);
    }

    @Override
    protected boolean breadcrumbCacheEnable() {
        return false;
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<SectionBreadcrumb> breadcrumbs) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs);
        Breadcrumb active = breadcrumbs.get(0);

        SectionBreadcrumb sectionBreadcrumb = (SectionBreadcrumb) active;
        Builder builder = Section.with();
        if (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
            builder.id(sectionBreadcrumb.getSection().getId());
        }
        Section section = builder.build();
        for (QuestionBreadcrumb questionBreadcrumb : sectionBreadcrumb.getBreadcrumbs()) {
            section.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId())
                    .number(questionBreadcrumb.getQuestionNumber()).build());
        }
        nextPage.addSection(section);
        return nextPage;
    }
}

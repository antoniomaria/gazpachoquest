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
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("SectionBySectionRelevanceAwareResolver")
public class SectionBySectionRelevanceAwareResolver extends AbstractResolver<SectionBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(SectionBySectionRelevanceAwareResolver.class);

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private SectionService sectionService;

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
            final Questionnaire questionnaire, Map<String, Object> answers, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {

        SectionBreadcrumb nextBreadcrumb = null;

        Integer position = sectionService.positionInQuestionnaireDefinition(lastBreadcrumb.getSection().getId());
        boolean found = false;
        Section next = null;

        do {
            position++;
            next = sectionService.findOneByPositionInQuestionnaireDefinition(questionnaireDefinition.getId(), position);
            if (next == null) {
                break;
            }
            found = isRevealed(next.getRelevance(), answers);
        } while (!found);
        
        if (logger.isDebugEnabled()){
            logger.debug("Displaying sectionId {} because condition ({}) is satisfied ", next.getId(), next.getRelevance());
        }

        // The respondent has reached the last question group
        if (next == null) {
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

    @Override
    protected SectionBreadcrumb findPreviousBreadcrumb(final QuestionnaireDefinition questionnaireDefinition,
            final Questionnaire questionnaire, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            return null;
        }
        Breadcrumb previous =  breadcrumbService.findByQuestionnaireIdAndPosition(
                questionnaire.getId(), lastBreadcrumbPosition - 1);
        Assert.isInstanceOf(SectionBreadcrumb.class, lastBreadcrumb);
        return (SectionBreadcrumb) previous;
    }

    private Section findFirstSection(int questionnaireDefinitionId) {
        // It assumes that the first section is always displayed
        return sectionService.findOneByPositionInQuestionnaireDefinition(questionnaireDefinitionId, INITIAL_POSITION);
    }

    @Override
    protected boolean breadcrumbCacheEnable() {
        return false;
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<SectionBreadcrumb> breadcrumbs, Map<String, Object> answers) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs, answers);
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

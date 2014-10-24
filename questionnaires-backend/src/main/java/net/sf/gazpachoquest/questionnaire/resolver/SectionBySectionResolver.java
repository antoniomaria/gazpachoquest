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
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.Section.Builder;
import net.sf.gazpachoquest.domain.core.SectionBreadcrumb;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("SectionBySectionResolver")
public class SectionBySectionResolver extends AbstractResolver<SectionBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private SectionService sectionService;

    protected SectionBySectionResolver() {
        super(RenderingMode.SECTION_BY_SECTION);
    }

    @Override
    protected List<SectionBreadcrumb> makeBreadcrumbs(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire) {
        List<SectionBreadcrumb> breadcrumbs = new ArrayList<>();
        SectionBreadcrumb breadcrumb = null;
        Integer questionnaireDefinitionId = questionnaireDefinition.getId();
        RandomizationStrategy randomizationStrategy = questionnaireDefinition.getRandomizationStrategy();
        if (RandomizationStrategy.SECTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Section> sections = sectionService.findByExample(
                    Section.with()
                            .questionnaireDefinition(
                                    QuestionnaireDefinition.with().id(questionnaireDefinitionId).build()).build(),
                    new SearchParameters());
            Collections.shuffle(sections);
            for (Section section : sections) {
                breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(section).last(Boolean.FALSE)
                        .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
                breadcrumbs.add(breadcrumb);
            }
            populateQuestionsBreadcrumbs(breadcrumbs, QUESTION_NUMBER_START_COUNTER);
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Question> questions = questionnaireDefinitionService.getQuestions(questionnaireDefinitionId);
            Collections.shuffle(questions);
            Integer questionPerPage = questionnaireDefinition.getQuestionsPerPage();
            int questionIdx = 0;
            Integer questionNumberCounter = QUESTION_NUMBER_START_COUNTER;
            for (Question question : questions) {
                if (questionIdx % questionPerPage == 0) {
                    breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).last(Boolean.FALSE)
                            .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
                    breadcrumbs.add(breadcrumb);
                }
                breadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).last(Boolean.FALSE)
                        .questionNumber(questionNumberCounter++).build());
                questionIdx++;
            }

        } else {
            Section section = sectionService.findOneByPositionInQuestionnaireDefinition(questionnaireDefinitionId, INITIAL_POSITION);
            breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(section)
                    .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
            breadcrumbs.add(breadcrumb);
            populateQuestionsBreadcrumbs(breadcrumbs, QUESTION_NUMBER_START_COUNTER);
        }
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    @Override
    protected SectionBreadcrumb findNextBreadcrumb(final QuestionnaireDefinition questionnaireDefinition,
            final Questionnaire questionnaire, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {

        SectionBreadcrumb breadcrumb = (SectionBreadcrumb) breadcrumbService.findByQuestionnaireIdAndPosition(
                questionnaire.getId(), lastBreadcrumbPosition + 1);

        SectionBreadcrumb nextBreadcrumb = null;

        // There is no real section when QuestionsRandomization is enabled
        if (breadcrumb == null
                && !questionnaireDefinition.getRandomizationStrategy().equals(
                        RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
            Assert.isInstanceOf(SectionBreadcrumb.class, lastBreadcrumb);

            Integer position = sectionService.positionInQuestionnaireDefinition(lastBreadcrumb.getSection().getId());
            Section next = sectionService.findOneByPositionInQuestionnaireDefinition(questionnaireDefinition.getId(),
                    position + 1);
            // The respondent has reached the last question group
            if (next == null) {
                return null;
            }
            nextBreadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(next)
                    .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
            Integer lastQuestionNumberDisplayed = extractLastQuestionNumberDisplayed(lastBreadcrumb);
            populateQuestionsBreadcrumbs(Arrays.asList(nextBreadcrumb), lastQuestionNumberDisplayed + 1);
        } else {
            nextBreadcrumb = breadcrumb;
        }
        return nextBreadcrumb;
    }

    private Integer extractLastQuestionNumberDisplayed(SectionBreadcrumb lastBreadcrumb) {
        int questionsCount = lastBreadcrumb.getBreadcrumbs().size();
        return lastBreadcrumb.getBreadcrumbs().get(questionsCount - 1).getQuestionNumber();
    }

    @Override
    protected SectionBreadcrumb findPreviousBreadcrumb(final QuestionnaireDefinition questionnaireDefinition,
            final Questionnaire questionnaire, final SectionBreadcrumb lastBreadcrumb,
            final Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            return null;
        }
        Breadcrumb breadcrumb = breadcrumbService.findByQuestionnaireIdAndPosition(questionnaire.getId(),
                lastBreadcrumbPosition - 1);
        Assert.isInstanceOf(SectionBreadcrumb.class, breadcrumb);
        return (SectionBreadcrumb) breadcrumb;
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

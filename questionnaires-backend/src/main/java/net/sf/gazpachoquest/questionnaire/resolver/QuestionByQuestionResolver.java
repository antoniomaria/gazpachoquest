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
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.Section.Builder;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.questionnaire.support.PageMetadataCreator;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnaireService;
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("QuestionByQuestionResolver")
public class QuestionByQuestionResolver extends AbstractResolver<QuestionBreadcrumb> implements PageResolver {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(QuestionByQuestionResolver.class);

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private PageMetadataCreator metadataCreator;

    public QuestionByQuestionResolver() {
        super(RenderingMode.QUESTION_BY_QUESTION);
    }

    @Override
    protected List<QuestionBreadcrumb> makeBreadcrumbs(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire) {
        List<QuestionBreadcrumb> breadcrumbs = new ArrayList<>();
        QuestionBreadcrumb breadcrumb = null;
        Integer questionnairDefinitionId = questionnaireDefinition.getId();
        RandomizationStrategy randomizationStrategy = questionnaireDefinition.getRandomizationStrategy();
        if (RandomizationStrategy.SECTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Section> sections = sectionService.findByExample(
                    Section.with()
                            .questionnaireDefinition(
                                    QuestionnaireDefinition.with().id(questionnairDefinitionId).build()).build(),
                    new SearchParameters());
            Collections.shuffle(sections);
            for (Section section : sections) {
                List<Question> questions = findQuestions(section);
                for (Question question : questions) {
                    breadcrumb = QuestionBreadcrumb.with().questionnaire(questionnaire).last(Boolean.FALSE)
                            .question(question).renderingMode(RenderingMode.QUESTION_BY_QUESTION).build();
                    breadcrumbs.add(breadcrumb);
                }
            }
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            List<Question> questions = questionnaireDefinitionService.getQuestions(questionnairDefinitionId);
            Collections.shuffle(questions);
            for (Question question : questions) {
                breadcrumb = QuestionBreadcrumb.with().questionnaire(questionnaire).last(Boolean.FALSE)
                        .question(question).renderingMode(RenderingMode.QUESTION_BY_QUESTION).build();
                breadcrumbs.add(breadcrumb);
            }
        } else {
            Question question = findFirstQuestion(questionnairDefinitionId);
            breadcrumb = QuestionBreadcrumb.with().questionnaire(questionnaire).last(Boolean.FALSE)
                    .renderingMode(RenderingMode.QUESTION_BY_QUESTION).question(question).build();
            breadcrumbs.add(breadcrumb);
        }
        breadcrumbs.get(0).setLast(Boolean.TRUE);
        return breadcrumbs;
    }

    @Override
    protected QuestionBreadcrumb findNextBreadcrumb(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire, QuestionBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {

        Breadcrumb breadcrumb = breadcrumbService.findByquestionnaireIdAndPosition(questionnaire.getId(),
                lastBreadcrumbPosition + 1);

        QuestionBreadcrumb nextBreadcrumb = null;

        if (breadcrumb == null) {
            Assert.isInstanceOf(QuestionBreadcrumb.class, lastBreadcrumb);

            Section lastSection = lastBreadcrumb.getQuestion().getSection();

            Integer position = questionService.findPositionInSection(lastBreadcrumb.getQuestion().getId());
            long questionsCount = sectionService.questionsCount(lastSection.getId());
            Question next = null;
            if (position < questionsCount - 1) { // Not last in group
                next = questionService.findOneByPositionInSection(lastSection.getId(), position + 1);
            } else {
                Integer sectionPosition = sectionService.positionInQuestionnairDefinition(lastSection.getId());
                Section nextSection = sectionService.findOneByPositionInQuestionnairDefinition(
                        questionnaireDefinition.getId(), sectionPosition + 1);

                if (nextSection == null) { // TODO handle exceptions
                    return null;
                }
                next = questionService.findOneByPositionInSection(nextSection.getId(), INITIAL_POSITION);
            }
            // Mark next element as last browsed.
            nextBreadcrumb = QuestionBreadcrumb.with().questionnaire(questionnaire).question(next)
                    .renderingMode(RenderingMode.QUESTION_BY_QUESTION).build();
        } else {
            Assert.isInstanceOf(QuestionBreadcrumb.class, breadcrumb);
            nextBreadcrumb = (QuestionBreadcrumb) breadcrumb;
        }

        return nextBreadcrumb;
    }

    @Override
    protected QuestionBreadcrumb findPreviousBreadcrumb(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire, QuestionBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        if (lastBreadcrumbPosition == INITIAL_POSITION) {
            logger.warn("Page out of range. First page is returned.");
            return null;
        }
        Breadcrumb breadcrumb = breadcrumbService.findByquestionnaireIdAndPosition(questionnaire.getId(),
                lastBreadcrumbPosition - 1);
        Assert.isInstanceOf(QuestionBreadcrumb.class, breadcrumb);
        return (QuestionBreadcrumb) breadcrumb;
    }

    @Override
    protected List<Question> findQuestions(Section section) {
        List<Question> questions;
        if (section.isRandomizationEnabled()) {
            questions = questionService
                    .findByExample(Question.with().section(Section.with().id(section.getId()).build()).build(),
                            new SearchParameters());
            Collections.shuffle(questions);
        } else {
            questions = questionService.findBySectionId(section.getId());
        }
        return questions;
    }

    private Question findFirstQuestion(int questionnairDefinitionId) {
        Section initialGroup = sectionService.findOneByPositionInQuestionnairDefinition(questionnairDefinitionId,
                INITIAL_POSITION);
        return questionService.findOneByPositionInSection(initialGroup.getId(), INITIAL_POSITION);
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<QuestionBreadcrumb> breadcrumbs) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs);

        Breadcrumb active = breadcrumbs.get(0);

        QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) active;
        Builder builder = Section.with();
        if (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
            builder.id(questionBreadcrumb.getQuestion().getSectionId());
        }
        Section section = builder.build();
        section.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId()).build());

        nextPage.addSection(section);
        return nextPage;
    }

}

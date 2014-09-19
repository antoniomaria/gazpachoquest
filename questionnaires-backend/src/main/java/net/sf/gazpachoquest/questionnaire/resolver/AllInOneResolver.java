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
import net.sf.gazpachoquest.domain.core.SectionBreadcrumb;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AllInOneResolver")
public class AllInOneResolver extends AbstractResolver<SectionBreadcrumb> implements PageResolver {

    public AllInOneResolver() {
        super(RenderingMode.ALL_IN_ONE);
    }

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private SectionService sectionService;

    @Override
    protected List<SectionBreadcrumb> makeBreadcrumbs(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire) {
        List<SectionBreadcrumb> breadcrumbs = new ArrayList<>();
        SectionBreadcrumb breadcrumb = null;
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
                breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(section).last(Boolean.TRUE)
                        .renderingMode(RenderingMode.ALL_IN_ONE).build();
                breadcrumbs.add(breadcrumb);
            }
            populateQuestionsBreadcrumbs(breadcrumbs);
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            // Container section
            breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).last(Boolean.TRUE)
                    .renderingMode(RenderingMode.ALL_IN_ONE).build();

            List<Question> questions = questionnaireDefinitionService.getQuestions(questionnairDefinitionId);
            Collections.shuffle(questions);
            for (Question question : questions) {
                breadcrumb.addBreadcrumb((QuestionBreadcrumb.with().question(question).last(Boolean.TRUE).build()));
            }
            breadcrumbs.add(breadcrumb);
        } else {
            List<Section> sections = sectionService.findByExample(
                    Section.with()
                            .questionnaireDefinition(
                                    QuestionnaireDefinition.with().id(questionnairDefinitionId).build()).build(),
                    new SearchParameters());
            for (Section section : sections) {
                breadcrumb = SectionBreadcrumb.with().questionnaire(questionnaire).section(section).last(Boolean.TRUE)
                        .renderingMode(RenderingMode.ALL_IN_ONE).build();
                breadcrumbs.add(breadcrumb);
            }
            populateQuestionsBreadcrumbs(breadcrumbs);
        }
        return breadcrumbs;
    }

    @Override
    protected SectionBreadcrumb findPreviousBreadcrumb(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire, SectionBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        return null;
    }

    @Override
    protected SectionBreadcrumb findNextBreadcrumb(QuestionnaireDefinition questionnaireDefinition,
            Questionnaire questionnaire, SectionBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        return null;
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<SectionBreadcrumb> breadcrumbs) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs);

        for (Breadcrumb breadcrumb : breadcrumbs) {
            SectionBreadcrumb sectionBreadcrumb = (SectionBreadcrumb) breadcrumb;

            Builder builder = Section.with();
            if (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
                builder.id(sectionBreadcrumb.getSection().getId());
            }
            Section section = builder.build();
            for (QuestionBreadcrumb questionBreadcrumb : sectionBreadcrumb.getBreadcrumbs()) {
                section.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId()).build());
            }
            nextPage.addSection(section);
        }
        return nextPage;
    }

}

package net.sf.gazpachoquest.questionnair.resolver;

import java.util.ArrayList;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AllInOneResolver")
public class AllInOneResolver extends AbstractResolver<QuestionGroupBreadcrumb> implements PageResolver {

    public AllInOneResolver() {
        super(RenderingMode.ALL_IN_ONE);
    }

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Override
    protected List<QuestionGroupBreadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair) {
        List<QuestionGroupBreadcrumb> breadcrumbs = new ArrayList<>();
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
                        .last(Boolean.TRUE).renderingMode(RenderingMode.ALL_IN_ONE).build();
                breadcrumbs.add(breadcrumb);
            }
            populateQuestionsBreadcrumbs(breadcrumbs);
        } else if (RandomizationStrategy.QUESTIONS_RANDOMIZATION.equals(randomizationStrategy)) {
            // Container questionGroup
            breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).last(Boolean.TRUE)
                    .renderingMode(RenderingMode.ALL_IN_ONE).build();

            List<Question> questions = questionnairDefinitionService.getQuestions(questionnairDefinitionId);
            Collections.shuffle(questions);
            for (Question question : questions) {
                breadcrumb.addBreadcrumb((QuestionBreadcrumb.with().question(question).last(Boolean.TRUE).build()));
            }
            breadcrumbs.add(breadcrumb);
        } else {
            List<QuestionGroup> questionGroups = questionGroupService.findByExample(
                    QuestionGroup.with()
                            .questionnairDefinition(QuestionnairDefinition.with().id(questionnairDefinitionId).build())
                            .build(), new SearchParameters());
            for (QuestionGroup questionGroup : questionGroups) {
                breadcrumb = QuestionGroupBreadcrumb.with().questionnair(questionnair).questionGroup(questionGroup)
                        .last(Boolean.TRUE).renderingMode(RenderingMode.ALL_IN_ONE).build();
                breadcrumbs.add(breadcrumb);
            }
            populateQuestionsBreadcrumbs(breadcrumbs);
        }
        return breadcrumbs;
    }

    @Override
    protected QuestionGroupBreadcrumb findPreviousBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, QuestionGroupBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        return null;
    }

    @Override
    protected QuestionGroupBreadcrumb findNextBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, QuestionGroupBreadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition) {
        return null;
    }

    @Override
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<QuestionGroupBreadcrumb> breadcrumbs) {
        PageStructure nextPage = super.createPageStructure(randomizationStrategy, breadcrumbs);

        for (Breadcrumb breadcrumb : breadcrumbs) {
            QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;

            Builder builder = QuestionGroup.with();
            if (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION)) {
                builder.id(questionGroupBreadcrumb.getQuestionGroup().getId());
            }
            QuestionGroup questionGroup = builder.build();
            for (QuestionBreadcrumb questionBreadcrumb : questionGroupBreadcrumb.getBreadcrumbs()) {
                questionGroup.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId()).build());
            }
            nextPage.addQuestionGroup(questionGroup);
        }
        return nextPage;
    }

}

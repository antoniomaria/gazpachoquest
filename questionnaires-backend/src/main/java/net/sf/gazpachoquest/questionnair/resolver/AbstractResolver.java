package net.sf.gazpachoquest.questionnair.resolver;

import java.lang.reflect.ParameterizedType;
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
import org.springframework.util.Assert;

public abstract class AbstractResolver<T extends Breadcrumb> implements PageResolver {

    private static final Logger logger = LoggerFactory.getLogger(AbstractResolver.class);

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

    private final Class<T> breadcrumbClazz;

    @SuppressWarnings("unchecked")
    protected AbstractResolver() {
        this.breadcrumbClazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    }

    @Override
    public PageStructure resolveNextPage(final Questionnair questionnair, final NavigationAction action) {
        Questionnair fetchedQuestionnair = questionnairService.findOne(questionnair.getId());
        QuestionnairDefinition questionnairDefinition = fetchedQuestionnair.getQuestionnairDefinition();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} page for questionnair {}", action.toString(), questionnairId);

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
            if (breadcrumbClazz.isAssignableFrom(breadcrumb.getClass())) {
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

    protected abstract Breadcrumb findPreviousBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract Breadcrumb findNextBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract List<Breadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair);

    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb) {
        PageStructure nextPage = new PageStructure();
        nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumb));
        QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
        for (QuestionBreadcrumb questionBreadcrumb : questionGroupBreadcrumb.getBreadcrumbs()) {
            nextPage.addQuestionsId(questionBreadcrumb.getQuestion().getId());
        }
        return nextPage;
    }

    protected void leaveBreakcrumbs(final Questionnair questionnair, List<Breadcrumb> breadcrumbs) {
        for (Breadcrumb newBreadcrumb : breadcrumbs) {
            questionnair.addBreadcrumb(newBreadcrumb);
        }
        questionnairService.save(questionnair);
    }

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
}

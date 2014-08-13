package net.sf.gazpachoquest.questionnair.resolver;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
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
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    protected final RenderingMode type;

    protected AbstractResolver(RenderingMode type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageStructure resolveNextPage(final Questionnair questionnair, final NavigationAction action) {
        Questionnair fetchedQuestionnair = questionnairService.findOne(questionnair.getId());
        QuestionnairDefinition questionnairDefinition = fetchedQuestionnair.getQuestionnairDefinition();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} page for questionnair {}", action.toString(), questionnairId);

        List<Object[]> result = breadcrumbService.findLastAndPosition(questionnairId);
        T breadcrumb = null;
        List<T> lastBreadcrumbs = new ArrayList<>();

        List<T> breadcrumbs = null;
        Integer lastBreadcrumbPosition = null;
        if (result.isEmpty()) { // First time entering the
                                // questionnairDefinition
            breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
            leaveBreakcrumbs(questionnair, breadcrumbs);
            populateLastBreadcrumbs(lastBreadcrumbs, breadcrumbs);
        } else {
            // At least one breadcrumb
            lastBreadcrumbPosition = (Integer) result.get(0)[1];
            breadcrumb = (T) result.get(0)[0];
            if (!breadcrumb.getRenderingMode().equals(type)) {
                // Clean dirties
                breadcrumbService.deleteByExample(
                        Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
                        new SearchParameters());
                breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
                leaveBreakcrumbs(questionnair, breadcrumbs);
                populateLastBreadcrumbs(lastBreadcrumbs, breadcrumbs);
            } else {
                if (!type.equals(RenderingMode.ALL_IN_ONE)) {
                    lastBreadcrumbs.add(breadcrumb);
                } else {
                    for (Object[] row : result) {
                        breadcrumb = (T) row[0];
                        lastBreadcrumbs.add(breadcrumb);
                    }
                }

            }

        }
        List<T> nextBreadcrumbs = new ArrayList<>();
        if (NavigationAction.ENTERING.equals(action)) {
            nextBreadcrumbs = lastBreadcrumbs;
        } else {
            T nextBreadcrumb;
            if (NavigationAction.NEXT.equals(action)) {
                nextBreadcrumb = findNextBreadcrumb(questionnairDefinition, questionnair, lastBreadcrumbs.get(0),
                        lastBreadcrumbPosition);
            } else {// PREVIOUS
                nextBreadcrumb = findPreviousBreadcrumb(questionnairDefinition, questionnair, lastBreadcrumbs.get(0),
                        lastBreadcrumbPosition);
            }
            // Prevent that questiongroups are still in range.
            if (nextBreadcrumb != null) {
                lastBreadcrumbs.get(0).setLast(Boolean.FALSE);
                nextBreadcrumb.setLast(Boolean.TRUE);
                leaveBreakcrumbs(questionnair, Arrays.asList(lastBreadcrumbs.get(0), nextBreadcrumb));
            } else {
                nextBreadcrumb = lastBreadcrumbs.get(0);
            }
            nextBreadcrumbs.add(nextBreadcrumb);
        }
        return createPageStructure(questionnairDefinition.getRandomizationStrategy(), nextBreadcrumbs);
    }

    protected abstract T findPreviousBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, T lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract T findNextBreadcrumb(QuestionnairDefinition questionnairDefinition, Questionnair questionnair,
            T lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract List<T> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition, Questionnair questionnair);

    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy, List<T> breadcrumbs) {
        PageStructure nextPage = new PageStructure();
        if (!breadcrumbs.isEmpty()) {
            nextPage.setMetadata(metadataCreator.create(randomizationStrategy, type, breadcrumbs.get(0)));
        }
        return nextPage;
    }

    protected void leaveBreakcrumbs(final Questionnair questionnair, List<T> breadcrumbs) {
        for (T newBreadcrumb : breadcrumbs) {
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
            shuffle(questions);
        } else {
            questions = questionService.findByQuestionGroupId(questionGroup.getId());
        }
        return questions;
    }

    protected void populateQuestionsBreadcrumbs(List<T> breadcrumbs) {
        for (Breadcrumb breadcrumb : breadcrumbs) {
            QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;

            QuestionGroup questionGroup = questionGroupBreadcrumb.getQuestionGroup();

            List<Question> questions = findQuestions(questionGroup);

            for (Question question : questions) {
                questionGroupBreadcrumb.addBreadcrumb(QuestionBreadcrumb.with().question(question).last(Boolean.FALSE)
                        .build());
            }
        }
    }

    private void populateLastBreadcrumbs(List<T> lastBreadcrumbs, List<T> breadcrumbs) {
        for (T breadcrumb : breadcrumbs) {
            if (!breadcrumb.isLast()) {
                break;
            }
            lastBreadcrumbs.add(breadcrumb);
        }
    }

    private void shuffle(List<Question> questions) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < questions.size(); i++) {
            int position = i + random.nextInt(questions.size() - i);
            Question temp = questions.get(i);
            Question other = questions.get(position);
            questions.set(i, other);
            questions.set(position, temp);
        }
    }
}

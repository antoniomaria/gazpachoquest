package net.sf.gazpachoquest.questionnair.resolver;

import java.lang.reflect.ParameterizedType;
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

    private final Class<T> breadcrumbClazz;

    protected final RenderingMode type;

    @SuppressWarnings("unchecked")
    protected AbstractResolver(RenderingMode type) {
        this.breadcrumbClazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
        this.type = type;
    }

    @Override
    public PageStructure resolveNextPage(final Questionnair questionnair, final NavigationAction action) {
        Questionnair fetchedQuestionnair = questionnairService.findOne(questionnair.getId());
        QuestionnairDefinition questionnairDefinition = fetchedQuestionnair.getQuestionnairDefinition();
        int questionnairId = questionnair.getId();
        logger.debug("Finding {} page for questionnair {}", action.toString(), questionnairId);

        List<Object[]> result = breadcrumbService.findLastAndPosition(questionnairId);
        Breadcrumb breadcrumb = null;
        List<Breadcrumb> lastBreadcrumbs = new ArrayList<Breadcrumb>();

        List<Breadcrumb> breadcrumbs = null;
        Integer lastBreadcrumbPosition = null;
        if (result.isEmpty()) { // First time entering the
                                // questionnairDefinition
            breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
            leaveBreakcrumbs(questionnair, breadcrumbs);

            for (Breadcrumb breadcrumb2 : breadcrumbs) {
                if (!breadcrumb2.isLast()) {
                    break;
                }
                lastBreadcrumbs.add(breadcrumb2);
            }
        } else {
            // At least one breadcrumb
            lastBreadcrumbPosition = (Integer) result.get(0)[1];
            breadcrumb = (Breadcrumb) result.get(0)[0];
            if (!breadcrumb.getRenderingMode().equals(type)) {
                breadcrumbService.deleteByExample(
                        Breadcrumb.withProps().questionnair(Questionnair.with().id(questionnairId).build()).build(),
                        new SearchParameters());
                breadcrumbs = makeBreadcrumbs(questionnairDefinition, questionnair);
                leaveBreakcrumbs(questionnair, breadcrumbs);
                for (Breadcrumb breadcrumb2 : breadcrumbs) {
                    if (!breadcrumb2.isLast()) {
                        break;
                    }
                    lastBreadcrumbs.add(breadcrumb2);
                }
            } else {
                if (!type.equals(RenderingMode.ALL_IN_ONE)) {
                    lastBreadcrumbs.add(breadcrumb);
                } else {
                    for (Object row : result) {
                        breadcrumb = (Breadcrumb) row;
                        lastBreadcrumbs.add(breadcrumb);
                    }
                }

            }

        }
        List<Breadcrumb> nextBreadcrumbs = null;
        if (NavigationAction.ENTERING.equals(action)) {
            nextBreadcrumbs = lastBreadcrumbs;
        } else {
            if (!RandomizationStrategy.QUESTIONS_RANDOMIZATION
                    .equals(questionnairDefinition.getRandomizationStrategy())) {
                // QuestionGroup is not applicable when questions are
                // randomized.
                // Assert.isTrue(lastBreadcrumb.getQuestionGroup() != null);
            }
            nextBreadcrumbs = new ArrayList<>();
            if (lastBreadcrumbs.size() == 1) {
                Breadcrumb nextBreadcrumb;
                if (NavigationAction.NEXT.equals(action)) {
                    nextBreadcrumb = findNextBreadcrumb(questionnairDefinition, questionnair, lastBreadcrumbs.get(0),
                            lastBreadcrumbPosition);
                } else {// PREVIOUS
                    nextBreadcrumb = findPreviousBreadcrumb(questionnairDefinition, questionnair,
                            lastBreadcrumbs.get(0), lastBreadcrumbPosition);
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
        }
        return nextBreadcrumbs != null ? createPageStructure(questionnairDefinition.getRandomizationStrategy(),
                nextBreadcrumbs) : null;
    }

    protected abstract Breadcrumb findPreviousBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract Breadcrumb findNextBreadcrumb(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair, Breadcrumb lastBreadcrumb, Integer lastBreadcrumbPosition);

    protected abstract List<Breadcrumb> makeBreadcrumbs(QuestionnairDefinition questionnairDefinition,
            Questionnair questionnair);

    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
            List<Breadcrumb> breadcrumbs) {
        PageStructure nextPage = new PageStructure();
        nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumbs.get(0)));
        return nextPage;
    }

    /*-
    protected PageStructure createPageStructure(RandomizationStrategy randomizationStrategy,
        List<Breadcrumb> breadcrumbs) {
    PageStructure nextPage = new PageStructure();
    // GroupsByGroups
    Breadcrumb active = breadcrumbs.get(0);
    if (breadcrumbs.size() > 0) {
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
    } else {
        if (active instanceof QuestionGroupBreadcrumb) {
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
        } else if (active instanceof QuestionBreadcrumb) {
            QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) active;

            Builder builder = QuestionGroup.with();
            // if
            // (!randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION))
            // {
            builder.id(questionBreadcrumb.getQuestion().getQuestionGroup().getId());
            // }
            QuestionGroup questionGroup = builder.build();
            questionGroup.addQuestion(Question.with().id(questionBreadcrumb.getQuestion().getId()).build());
            nextPage.addQuestionGroup(questionGroup);
        }

    }

    if (breadcrumbs.size() == 1) {
        nextPage.setMetadata(metadataCreator.create(randomizationStrategy, breadcrumbs.get(0)));
    }

    for (Breadcrumb breadcrumb : breadcrumbs) {
        if (breadcrumb instanceof QuestionGroupBreadcrumb) {
            QuestionGroupBreadcrumb questionGroupBreadcrumb = (QuestionGroupBreadcrumb) breadcrumb;
            for (QuestionBreadcrumb questionBreadcrumb : questionGroupBreadcrumb.getBreadcrumbs()) {
                nextPage.addQuestionsId(questionBreadcrumb.getQuestion().getId());
            }
        } else {
            QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) breadcrumb;
            nextPage.addQuestionsId(questionBreadcrumb.getQuestion().getId());
        }
    }
    return nextPage;
    }*/

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
            shuffle(questions);
        } else {
            questions = questionService.findByQuestionGroupId(questionGroup.getId());
        }
        return questions;
    }

    protected void populateQuestionsBreadcrumbs(List<Breadcrumb> breadcrumbs) {
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

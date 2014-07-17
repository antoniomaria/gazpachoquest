package net.sf.gazpachoquest.questionnair.support;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageMetadataCreatorImpl implements PageMetadataCreator {

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Override
    public PageMetadataStructure create(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb) {
        int position = -1;
        int count = -1;
        if (breadcrumb instanceof QuestionGroupBreadcrumb) {
            QuestionGroup questionGroup = ((QuestionGroupBreadcrumb) breadcrumb).getQuestionGroup();

            if (RandomizationStrategy.NONE.equals(randomizationStrategy)) {
                questionGroup = questionGroupService.findOne(questionGroup.getId());
                position = questionGroupService.positionInQuestionnairDefinition(questionGroup.getId());
                count = questionnairDefinitionService.questionGroupsCount(questionGroup.getQuestionnairDefinition()
                        .getId());
            } else {
                count = breadcrumbService.countByQuestionnair(breadcrumb.getQuestionnair().getId());
                position = (Integer) breadcrumbService.findLastAndPosition(breadcrumb.getQuestionnair().getId()).get(0)[1];
            }
        } else if (breadcrumb instanceof QuestionBreadcrumb) {
            Question question = ((QuestionBreadcrumb) breadcrumb).getQuestion();
            QuestionGroup questionGroup = question.getQuestionGroup();

            Integer questionnairDefinitionId = questionGroup.getQuestionnairDefinition().getId();

            count = questionnairDefinitionService.questionsCount(questionnairDefinitionId);

            Integer questionGroupId = question.getQuestionGroup().getId();

            Integer positionInQuestionGroup = questionService.findPositionInQuestionGroup(question.getId());

            List<Object[]> counts = questionnairDefinitionService
                    .questionsCountGroupByQuestionGroups(questionnairDefinitionId);
            Integer positionInQuestionnairDefition = 0;
            for (Object[] objects : counts) {
                Integer groupId = (Integer) objects[0];
                if (questionGroupId.equals(groupId)) {
                    break;
                }
                positionInQuestionnairDefition += ((Long) objects[1]).intValue();
            }
            position = positionInQuestionnairDefition + positionInQuestionGroup;
        }
        return PageMetadataStructure.with().count(count).number(position + 1).build();
    }

}

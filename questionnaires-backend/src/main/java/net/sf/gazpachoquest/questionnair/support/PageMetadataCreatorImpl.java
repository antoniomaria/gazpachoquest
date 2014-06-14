package net.sf.gazpachoquest.questionnair.support;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.support.QuestionnairElement;
import net.sf.gazpachoquest.dto.PageMetadataDTO;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;

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

    @Override
    public PageMetadataDTO create(QuestionnairElement questionnairElement) {
        int position = -1;
        int count = -1;
        PageMetadataDTO metadata = new PageMetadataDTO();
        if (questionnairElement instanceof QuestionGroup) {
            QuestionGroup questionGroup = (QuestionGroup) questionnairElement;
            position = questionGroupService.positionInQuestionnairDefinition(questionGroup.getId());
            count = questionnairDefinitionService
                    .questionGroupsCount(questionGroup.getQuestionnairDefinition().getId());
        } else if (questionnairElement instanceof Question) {
            Question question = (Question) questionnairElement;
            
            QuestionGroup questionGroup = question.getQuestionGroup();
            
            Integer questionnairDefinitionId = questionGroup.getQuestionnairDefinition().getId();
            
            Integer questionGroupId = question.getQuestionGroup().getId();
            
            Integer questionGroupCount = questionnairDefinitionService.questionGroupsCount(questionnairDefinitionId);
            Integer posInQuestionnairDef = questionGroupService.positionInQuestionnairDefinition(questionGroupId);
            
            Integer posInGroup = questionService.findPositionInQuestionGroup(question.getId());
            
        }
        metadata.setCount(count);
        metadata.setNumber(position + 1);
        return metadata;
    }

}

package net.sf.gazpachoquest.questionnaire.support;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.SectionBreadcrumb;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.SectionService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageMetadataCreatorImpl implements PageMetadataCreator {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Override
    public PageMetadataStructure create(RandomizationStrategy randomizationStrategy, RenderingMode type,
            Breadcrumb breadcrumb) {
        int position = -1;
        int count = -1;
        if (type.equals(RenderingMode.ALL_IN_ONE)) {
            return PageMetadataStructure.with().count(1).number(1).build();
        }
        if (breadcrumb instanceof SectionBreadcrumb) {
            Section section = ((SectionBreadcrumb) breadcrumb).getSection();

            if (RandomizationStrategy.NONE.equals(randomizationStrategy)) {
                section = sectionService.findOne(section.getId());
                position = sectionService.positionInQuestionnairDefinition(section.getId());
                count = questionnaireDefinitionService.sectionsCount(section.getQuestionnairDefinition()
                        .getId());
            } else {
                count = breadcrumbService.countByQuestionnair(breadcrumb.getQuestionnair().getId());
                position = (Integer) breadcrumbService.findLastAndPosition(breadcrumb.getQuestionnair().getId()).get(0)[1];
            }
        } else if (breadcrumb instanceof QuestionBreadcrumb) {
            if (RandomizationStrategy.NONE.equals(randomizationStrategy)) {
                Question question = ((QuestionBreadcrumb) breadcrumb).getQuestion();
                Section section = question.getSection();

                Integer questionnairDefinitionId = section.getQuestionnairDefinition().getId();

                count = questionnaireDefinitionService.questionsCount(questionnairDefinitionId);

                Integer sectionId = question.getSection().getId();

                Integer positionInSection = questionService.findPositionInSection(question.getId());

                List<Object[]> counts = questionnaireDefinitionService
                        .questionsCountGroupBySections(questionnairDefinitionId);
                Integer positionInQuestionnairDefition = 0;
                for (Object[] objects : counts) {
                    Integer groupId = (Integer) objects[0];
                    if (sectionId.equals(groupId)) {
                        break;
                    }
                    positionInQuestionnairDefition += ((Long) objects[1]).intValue();
                }
                position = positionInQuestionnairDefition + positionInSection;
            } else {
                count = breadcrumbService.countByQuestionnair(breadcrumb.getQuestionnair().getId());
                position = (Integer) breadcrumbService.findLastAndPosition(breadcrumb.getQuestionnair().getId()).get(0)[1];
            }
        }
        return PageMetadataStructure.with().count(count).number(position + 1).build();
    }

}

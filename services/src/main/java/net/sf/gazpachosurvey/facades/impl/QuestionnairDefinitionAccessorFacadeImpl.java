package net.sf.gazpachosurvey.facades.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.facades.QuestionnairDefinitionAccessorFacade;
import net.sf.gazpachosurvey.services.QuestionService;
import net.sf.gazpachosurvey.services.QuestionnairDefinitionService;
import net.sf.gazpachosurvey.types.Language;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairDefinitionAccessorFacadeImpl implements QuestionnairDefinitionAccessorFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private QuestionService questionService;

    @Override
    public QuestionnairDefinitionDTO findOneQuestionnairDefinition(final Integer questionnairDefinitionId) {
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionService.findOne(questionnairDefinitionId);
        return mapper.map(questionnairDefinition, QuestionnairDefinitionDTO.class);
    }

    @Override
    public QuestionDTO findOneQuestion(final Integer questionId) {
        Question question = questionService.findOne(questionId);
        return mapper.map(question, QuestionDTO.class);
    }

    @Override
    public Set<Language> findQuestionnairDefinitionTranslations(final Integer questionnairDefinitionId) {
        return questionnairDefinitionService.translationsSupported(questionnairDefinitionId);
    }

}

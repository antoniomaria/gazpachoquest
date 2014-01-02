package net.sf.gazpachosurvey.facades.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.facades.QuestionnairDefinitionAccessorFacade;
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

    @Override
    public QuestionnairDefinitionDTO findOneSurvey(final Integer surveyId) {
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionService.findOne(surveyId);
        return mapper.map(questionnairDefinition, QuestionnairDefinitionDTO.class);
    }

    @Override
    public Set<Language> findSurveyTranslations(final Integer surveyId) {
        return questionnairDefinitionService.translationsSupported(surveyId);
    }

}

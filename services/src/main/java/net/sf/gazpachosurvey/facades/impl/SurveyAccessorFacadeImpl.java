package net.sf.gazpachosurvey.facades.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.facades.SurveyAccessorFacade;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.Language;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyAccessorFacadeImpl implements SurveyAccessorFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private SurveyService surveyService;

    @Override
    public SurveyDTO findOneSurvey(final Integer surveyId) {
        Survey survey = surveyService.findOne(surveyId);
        return mapper.map(survey, SurveyDTO.class);
    }

    @Override
    public Set<Language> findSurveyTranslations(final Integer surveyId) {
        return surveyService.translationsSupported(surveyId);
    }

}

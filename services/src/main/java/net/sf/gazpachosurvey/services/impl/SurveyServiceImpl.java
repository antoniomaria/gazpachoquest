package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.services.SurveyService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Integer addSurvey(SurveyDTO survey) {
        Survey entity = mapper.map(survey, Survey.class);
        Survey created = surveyRepository.save(entity);
        return created.getId();
    }

}

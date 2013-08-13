package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.services.SurveyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl extends AbstractPersistenceService<Survey, SurveyDTO, Integer> implements SurveyService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        super(surveyRepository, Survey.class, SurveyDTO.class);
    }
}

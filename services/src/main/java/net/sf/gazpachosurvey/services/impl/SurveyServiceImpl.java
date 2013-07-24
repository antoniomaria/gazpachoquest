package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.SurveyService;

import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl extends
        AbstractPersistenceService<Survey, Integer> implements SurveyService {

    public SurveyServiceImpl(GenericRepository<Survey, Integer> repository) {
        super(repository);
    }

}

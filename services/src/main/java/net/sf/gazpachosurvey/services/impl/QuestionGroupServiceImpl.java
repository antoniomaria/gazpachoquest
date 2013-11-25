package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionGroupTranslationRepository;
import net.sf.gazpachosurvey.services.QuestionGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionGroupServiceImpl
        extends
        AbstractLocalizedPersistenceService<QuestionGroup, QuestionGroupDTO, QuestionGroupTranslation, QuestionGroupLanguageSettings, QuestionGroupLanguageSettingsDTO>
        implements QuestionGroupService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    public QuestionGroupServiceImpl(QuestionGroupRepository repository,
            QuestionGroupTranslationRepository translationRepository) {
        super(repository, translationRepository, QuestionGroup.class,
                QuestionGroupDTO.class, QuestionGroupTranslation.class,
                QuestionGroupLanguageSettings.class,
                QuestionGroupLanguageSettingsDTO.class,
                new QuestionGroupTranslation.Builder());
    }
    
    @Override
    public QuestionGroupDTO save(QuestionGroupDTO dto) {
    	// TODO Auto-generated method stub
    	return super.save(dto);
    }
}

package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.MailMessage;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.dynamic.RespondentRepository;
import net.sf.gazpachosurvey.repository.i18.SurveyTranslationRepository;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SurveyServiceImpl extends
        AbstractLocalizedPersistenceService<Survey, SurveyDTO, SurveyTranslation, SurveyLanguageSettings, SurveyLanguageSettingsDTO> implements
        SurveyService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private RespondentRepository respondentRepository;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private SurveyTranslationRepository surveyTranslationRepository;
    
    
    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, SurveyTranslationRepository translationRepository) {
        super(surveyRepository, translationRepository, Survey.class, SurveyDTO.class, SurveyTranslation.class, SurveyLanguageSettings.class);
    }
    @Override
    public SurveyDTO save(SurveyDTO survey) {
        Survey entity = mapper.map(survey, entityClazz);
        if (entity.isNew()) {
            entity.setStatus(EntityStatus.DRAFT);
        }
        MailMessage message = MailMessage.with().to("antonio@gmail.com")
                .build();

        mailMessageRepository.save(message);
        return mapper.map(repository.save(entity), SurveyDTO.class);
    }

    @Override
    public SurveyDTO confirm(SurveyDTO survey) {
        Survey entity = repository.findOne(survey.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            respondentRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return survey;
    }
    /*

    @Override
    public void saveTranslation(Integer surveyId, Language language,
            SurveyLanguageSettingsDTO languageSettingsDTO) {
        Survey survey = repository.findOne(surveyId);
        SurveyTranslation translation = survey.getTranslations().get(language);
        if (translation == null) {
            translation =  new SurveyTranslation();
            translation.setSurvey(survey);
            translation.setLanguage(language);
        }
        SurveyLanguageSettings languageSettings = mapper.map(languageSettingsDTO, SurveyLanguageSettings.class);
        translation.setLanguageSettings(languageSettings);
        surveyTranslationRepository.save(translation);
    }
*/
}

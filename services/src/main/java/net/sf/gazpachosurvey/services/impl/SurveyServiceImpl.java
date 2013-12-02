package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.dynamic.RespondentAnswersRepository;
import net.sf.gazpachosurvey.repository.i18.SurveyTranslationRepository;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SurveyServiceImpl
        extends
        AbstractLocalizedPersistenceService<Survey, SurveyDTO, SurveyTranslation, SurveyLanguageSettings, SurveyLanguageSettingsDTO>
        implements SurveyService {

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private RespondentAnswersRepository respondentAnswersRepository;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private SurveyTranslationRepository surveyTranslationRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, SurveyTranslationRepository translationRepository) {
        super(surveyRepository, translationRepository, Survey.class, SurveyDTO.class, SurveyTranslation.class,
                SurveyLanguageSettings.class, SurveyLanguageSettingsDTO.class, new SurveyTranslation.Builder());
    }

    public Survey save(Survey survey) {
        Survey entity = null;
        if (survey.isNew()) {
            survey.setStatus(EntityStatus.DRAFT);
            //entity = repository.saveWithoutFlush(survey);
            entity = repository.save(survey);
        }else{
            entity = repository.findOne(survey.getId());
            // User creator = entity.getCreatedBy();
            mapper.map(survey, entity);
        }
        return entity;
    }

    
    public SurveyDTO saveXX(SurveyDTO survey) {
        Survey entity = null;
        if (survey.isNew()) {
            entity = mapper.map(survey, entityClazz);
            entity.setStatus(EntityStatus.DRAFT);
        }else{
            entity = repository.findOne(survey.getId());
          //  User creator = entity.getCreatedBy();
            mapper.map(survey, entity);
        }
        entity = repository.save(entity);
        return mapper.map(entity, SurveyDTO.class);
    }

    @Override
    public SurveyDTO confirm(SurveyDTO survey) {
        Survey entity = repository.findOne(survey.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            respondentAnswersRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return survey;
    }

}

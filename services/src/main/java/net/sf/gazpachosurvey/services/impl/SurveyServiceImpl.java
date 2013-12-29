package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.repository.MailMessageRepository;
import net.sf.gazpachosurvey.repository.QuestionGroupRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.dynamic.RespondentAnswersRepository;
import net.sf.gazpachosurvey.repository.i18.SurveyTranslationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl extends
        AbstractLocalizedPersistenceService<Survey, SurveyTranslation, SurveyLanguageSettings> implements SurveyService {

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private RespondentAnswersRepository respondentAnswersRepository;

    @Autowired
    private SurveyTranslationRepository surveyTranslationRepository;

    @Autowired
    public SurveyServiceImpl(final SurveyRepository surveyRepository,
            final SurveyTranslationRepository translationRepository) {
        super(surveyRepository, translationRepository, new SurveyTranslation.Builder());
    }

    @Override
    public Survey confirm(final Survey survey) {
        Survey entity = repository.findOne(survey.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            respondentAnswersRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return survey;
    }

    @Override
    public long questionGroupsCount(final Integer surveyId) {
        return questionGroupRepository.countByExample(QuestionGroup.with().survey(Survey.with().id(surveyId).build())
                .build(), new SearchParameters());
    }

    @Override
    public Survey save(final Survey survey) {
        Survey existing = null;
        if (survey.isNew()) {
            survey.setStatus(EntityStatus.DRAFT);
            existing = repository.save(survey);
        } else {
            existing = repository.findOne(survey.getId());
            existing.setLanguage(survey.getLanguage());
            existing.setLanguageSettings(survey.getLanguageSettings());
            for (QuestionGroup questionGroup : survey.getQuestionGroups()) {
                if (!questionGroup.isNew()) {
                    continue;
                }
                existing.addQuestionGroup(questionGroup);
            }
        }
        return existing;
    }
}

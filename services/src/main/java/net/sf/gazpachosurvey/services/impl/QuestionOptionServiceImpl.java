package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachosurvey.repository.QuestionOptionRepository;
import net.sf.gazpachosurvey.repository.i18.QuestionOptionTranslationRepository;
import net.sf.gazpachosurvey.services.QuestionOptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionOptionServiceImpl extends
        AbstractLocalizedPersistenceService<QuestionOption, QuestionOptionTranslation, QuestionOptionLanguageSettings>
        implements QuestionOptionService {

    @Autowired
    public QuestionOptionServiceImpl(final QuestionOptionRepository repository,
            final QuestionOptionTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionOptionTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionOption save(final QuestionOption entity) {
        Assert.state(!entity.isNew(), "QuestionOption must be already persisted. Try by adding to question first.");
        QuestionOption existing = repository.save(entity);
        existing.setLanguage(entity.getLanguage());
        existing.setLanguageSettings(entity.getLanguageSettings());
        return existing;
    }
}

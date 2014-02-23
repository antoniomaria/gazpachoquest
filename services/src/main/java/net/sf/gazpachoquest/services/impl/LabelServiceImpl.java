package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.repository.LabelRepository;
import net.sf.gazpachoquest.repository.i18.LabelTranslationRepository;
import net.sf.gazpachoquest.services.LabelService;
import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.LabelTranslation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class LabelServiceImpl extends
        AbstractLocalizedPersistenceService<Label, LabelTranslation, LabelLanguageSettings> implements LabelService {

    @Autowired
    public LabelServiceImpl(final LabelRepository repository, final LabelTranslationRepository translationRepository) {
        super(repository, translationRepository, new LabelTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = false)
    public Label save(final Label entity) {
        Assert.state(!entity.isNew(), "Label must be already persisted. Try by adding to labelSet first.");
        Label existing = repository.save(entity);
        existing.setLanguage(entity.getLanguage());
        existing.setLanguageSettings(entity.getLanguageSettings());
        return existing;
    }

}

/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachoquest.repository.QuestionOptionRepository;
import net.sf.gazpachoquest.repository.i18.QuestionOptionTranslationRepository;
import net.sf.gazpachoquest.services.QuestionOptionService;

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

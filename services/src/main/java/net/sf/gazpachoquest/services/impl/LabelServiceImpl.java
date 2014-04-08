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

import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.i18.LabelTranslation;
import net.sf.gazpachoquest.repository.LabelRepository;
import net.sf.gazpachoquest.repository.i18.LabelTranslationRepository;
import net.sf.gazpachoquest.services.LabelService;

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

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
package net.sf.gazpachoquest.facades.impl;

import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.MailMessageFacade;
import net.sf.gazpachoquest.services.MailMessageTemplateService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailMessageFacadeImpl implements MailMessageFacade {

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    @Autowired
    private Mapper mapper;

    public MailMessageFacadeImpl() {
        super();
    }

    @Override
    public MailMessageTemplateDTO save(final MailMessageTemplateDTO mailMessageTemplate) {
        MailMessageTemplate entity = mapper.map(mailMessageTemplate, MailMessageTemplate.class);
        entity = mailMessageTemplateService.save(entity);
        return mapper.map(entity, MailMessageTemplateDTO.class);
    }

    @Override
    public TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> saveTranslation(
            final TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation) {

        MailMessageTemplateLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                MailMessageTemplateLanguageSettings.class);

        MailMessageTemplateTranslation translationEntity = MailMessageTemplateTranslation.with()
                .language(translation.getLanguage()).languageSettings(languageSettings)
                .translatedEntityId(translation.getTranslatedEntity().getId()).build();

        translationEntity = mailMessageTemplateService.saveTranslation(translationEntity);
        translation.setId(translationEntity.getId());
        return translation;
    }
}

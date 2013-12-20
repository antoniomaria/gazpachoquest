package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.facades.MailMessageFacade;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailMessageFacadeImpl implements MailMessageFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    public MailMessageFacadeImpl() {
        super();
    }

    @Override
    public MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate) {
        MailMessageTemplate entity = mapper.map(mailMessageTemplate, MailMessageTemplate.class);
        entity = mailMessageTemplateService.save(entity);
        return mapper.map(entity, MailMessageTemplateDTO.class);
    }

    @Override
    public TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> saveTranslation(
            TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation) {

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

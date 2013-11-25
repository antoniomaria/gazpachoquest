package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;
import net.sf.gazpachosurvey.repository.i18.MailMessageTemplateTranslationRepository;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailMessageTemplateServiceImpl
        extends
        AbstractLocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateDTO, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings, MailMessageTemplateLanguageSettingsDTO>
        implements MailMessageTemplateService {

    @Autowired
    public MailMessageTemplateServiceImpl(MailMessageTemplateRepository repository,
            MailMessageTemplateTranslationRepository translationRepository) {
        super(repository, translationRepository, MailMessageTemplate.class, MailMessageTemplateDTO.class,
                MailMessageTemplateTranslation.class, MailMessageTemplateLanguageSettings.class,
                MailMessageTemplateLanguageSettingsDTO.class, new MailMessageTemplateTranslation.Builder());
    }
}

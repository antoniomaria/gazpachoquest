package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;
import net.sf.gazpachosurvey.types.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailMessageTemplateServiceImpl
        extends
        AbstractLocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateDTO, Integer>
        implements MailMessageTemplateService {

    @Autowired
    public MailMessageTemplateServiceImpl(
            MailMessageTemplateRepository repository) {
        super(repository, MailMessageTemplate.class, MailMessageTemplateDTO.class);
    }
    
    public void addTranslation(MailMessageTemplateDTO mailMessageTemplate,
            Language language,
            MailMessageTemplateLanguageSettingsDTO languageSettings) {
        MailMessageTemplate entity = mapper.map(mailMessageTemplate,
                MailMessageTemplate.class);
        MailMessageTemplateLanguageSettings languageSettingsEntity = mapper
                .map(languageSettings,
                        MailMessageTemplateLanguageSettings.class);
        entity.addTranslation(language, languageSettingsEntity);
        repository.save(entity);
    }

}

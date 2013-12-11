package net.sf.gazpachosurvey.services.impl;

import java.util.Map;
import java.util.Set;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;
import net.sf.gazpachosurvey.repository.i18.MailMessageTemplateTranslationRepository;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;
import net.sf.gazpachosurvey.types.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailMessageTemplateServiceImpl
        extends
        AbstractLocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings>
        implements MailMessageTemplateService {

    @Autowired
    public MailMessageTemplateServiceImpl(MailMessageTemplateRepository repository,
            MailMessageTemplateTranslationRepository translationRepository) {
        super(repository, translationRepository, new MailMessageTemplateTranslation.Builder());
    }

    public MailMessageTemplate save(MailMessageTemplate aMailMessageTemplate) {
        MailMessageTemplate existing = null;
        if (aMailMessageTemplate.isNew()) {
            existing = repository.save(aMailMessageTemplate);
        } else {
            existing = repository.findOne(aMailMessageTemplate.getId());
            existing.setSurvey(aMailMessageTemplate.getSurvey());
            existing.setFromAddress(aMailMessageTemplate.getFromAddress());
            existing.setReplyTo(aMailMessageTemplate.getReplyTo());
            existing.setLanguageSettings(aMailMessageTemplate.getLanguageSettings());
            existing.setType(aMailMessageTemplate.getType());

            Map<Language, MailMessageTemplateTranslation> translations = aMailMessageTemplate.getTranslations();
                Map<Language, MailMessageTemplateTranslation> supportedTranslations = existing.getTranslations();
                for (Language language : translations.keySet()) {
                    MailMessageTemplateTranslation translation = translations.get(language);
                    if (supportedTranslations.get(language) == null) {
                        existing.addTranslation(language, translation);
                    }
            }
        }
        return existing;
    }
}

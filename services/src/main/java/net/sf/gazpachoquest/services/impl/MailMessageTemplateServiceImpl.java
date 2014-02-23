package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.repository.MailMessageTemplateRepository;
import net.sf.gazpachoquest.repository.i18.MailMessageTemplateTranslationRepository;
import net.sf.gazpachoquest.services.MailMessageTemplateService;
import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailMessageTemplateServiceImpl
        extends
        AbstractLocalizedPersistenceService<MailMessageTemplate, MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings>
        implements MailMessageTemplateService {

    @Autowired
    public MailMessageTemplateServiceImpl(final MailMessageTemplateRepository repository,
            final MailMessageTemplateTranslationRepository translationRepository) {
        super(repository, translationRepository, new MailMessageTemplateTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = false)
    public MailMessageTemplate save(final MailMessageTemplate entity) {
        MailMessageTemplate existing = null;
        if (entity.isNew()) {
            existing = repository.save(entity);
        } else {
            existing = repository.findOne(entity.getId());
            existing.setQuestionnairDefinition(entity.getQuestionnairDefinition());
            existing.setFromAddress(entity.getFromAddress());
            existing.setReplyTo(entity.getReplyTo());
            existing.setLanguageSettings(entity.getLanguageSettings());
            existing.setType(entity.getType());
            /*
             * Map<Language, MailMessageTemplateTranslation> translations =
             * entity.getTranslations(); Map<Language,
             * MailMessageTemplateTranslation> supportedTranslations =
             * existing.getTranslations(); for (Language
             * language : translations.keySet()) {
             * MailMessageTemplateTranslation translation =
             * translations.get(language); if
             * (supportedTranslations.get(language) == null) {
             * existing.addTranslation(language, translation); } }
             */
        }
        return existing;
    }
    /*
     * public MailMessageTemplateTranslation
     * saveTranslation(MailMessageTemplateTranslation translation) {
     * Assert.state(!translation.isNew(),
     * "MailMessageTemplateTranslation must be already persisted. Try by adding to MailMessageTemplate first."
     * );
     * MailMessageTemplateTranslation existing =
     * translationRepository.findOne(translation.getId());
     * existing.setLanguageSettings(translation.getLanguageSettings()); return
     * existing; }
     */
}

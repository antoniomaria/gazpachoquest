package net.sf.gazpachosurvey.services.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Localizable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.LocalizedPersistenceService;
import net.sf.gazpachosurvey.types.Language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public abstract class AbstractLocalizedPersistenceService<L extends Localizable<LS, TR>, TR extends Translation<LS>, LS extends LanguageSettings>
        extends AbstractPersistenceService<L> implements LocalizedPersistenceService<L, TR, LS> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractLocalizedPersistenceService.class);

    protected GenericRepository<TR> translationRepository;

    protected TranslationBuilder<TR, LS> translationBuilder;

    @PersistenceContext
    private EntityManager em;

    protected AbstractLocalizedPersistenceService(GenericRepository<L> repository,
            GenericRepository<TR> translationRepository) {
        super(repository);
        this.translationRepository = translationRepository;
    }

    @Override
    public L findOne(Integer id, Language language) {
        L entity = repository.findOne(id);
        Assert.notNull(language, "Language is required");

        if (entity == null) {
            return null;
        }
        LS languageSettings = entity.getLanguageSettings();
        if (entity.getLanguage().equals(language)) {
            languageSettings = entity.getLanguageSettings();
        } else {
            Map<Language, TR> translations = entity.getTranslations();
            TR tr = translations.get(language);
            if (tr != null) {
                languageSettings = tr.getLanguageSettings();
            } else {
                logger.warn("No translation in " + language
                        + " for Entity of type {} with id {}. Providing default language", entity.getClass()
                        .getSimpleName(), entity.getId());
                languageSettings = entity.getLanguageSettings();
                language = entity.getLanguage();
            }
        }
        // Otherwise the entity is modified after session commit
        em.detach(entity);
        entity.setLanguage(language);
        entity.setLanguageSettings(languageSettings);
        return entity;
    }

    @Override
    public TR saveTranslation(TR translation) {
        TR existing = null;
        if (translation.isNew()) {
            existing = translationRepository.save(translation);
        } else {
            existing = translationRepository.findOne(translation.getId());
            existing.setLanguageSettings(translation.getLanguageSettings());
        }
        return existing;
    }

    @Override
    public Set<Language> translationsSupported(Integer entityId) {
        L entity = super.repository.findOne(entityId);
        if (entity == null) {
            return null;
        }

        TR translationExample = translationBuilder.translatedEntityId(entityId).build();

        List<TR> supportedLanguages = translationRepository.findByExample(translationExample, new SearchParameters());
        List<Language> list = new ArrayList<>();
        for (TR tr : supportedLanguages) {
            list.add(tr.getLanguage());
        }
        return list.isEmpty() ? EnumSet.noneOf(Language.class) : EnumSet.copyOf(list);
    }

}

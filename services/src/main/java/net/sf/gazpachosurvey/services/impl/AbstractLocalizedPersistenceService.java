package net.sf.gazpachosurvey.services.impl;

import org.springframework.util.Assert;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Localizable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.repository.support.LocalizedRepository;
import net.sf.gazpachosurvey.services.LocalizedPersistenceService;
import net.sf.gazpachosurvey.types.Language;

public abstract class AbstractLocalizedPersistenceService<L extends Localizable<LS, TR>, D extends Identifiable, TR extends Translation<LS>, LS extends LanguageSettings, LSD extends LanguageSettings>
        extends AbstractPersistenceService<L, D> implements
        LocalizedPersistenceService<D, LSD> {

    protected LocalizedRepository<L> localizedRepository;

    protected GenericRepository<TR> translationRepository;

    protected Class<TR> translationClazz;

    protected Class<LS> languageSettingsClazz;

    AbstractLocalizedPersistenceService(
            LocalizedRepository<L> repository,
            GenericRepository<TR> translationRepository, Class<L> entityClazz,
            Class<D> dtoClazz, Class<TR> translationClazz,Class<LS> languageSettingsClazz) {
        super(repository, entityClazz, dtoClazz);
        this.localizedRepository = repository;
        this.translationRepository = translationRepository;
        this.translationClazz = translationClazz;
        this.languageSettingsClazz = languageSettingsClazz;
    }

    @Override
    public D findOne(Integer id, Language language) {
        L entity = localizedRepository.findOne(id, language);
        D dto = null;
        if (entity != null) {
            dto = mapper.map(entity, dtoClazz);
        }
        return dto;
    }

    public void saveTranslation(Integer entityId, Language language,
            LSD languageSettingsDTO) {
        Assert.notNull(language, "Language is required");
        Assert.notNull(language, "EntityId is required");
        L entity = repository.findOne(entityId);
        TR translation = entity.getTranslations().get(language);
        try {
            if (translation == null) {
                translation = translationClazz.newInstance();
                translation.setLanguage(language);
                entity.addTranslation(language, translation);
            }
            LS languageSettings = mapper.map(languageSettingsDTO,
                    languageSettingsClazz);
            translation.setLanguageSettings(languageSettings);
            translationRepository.save(translation);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

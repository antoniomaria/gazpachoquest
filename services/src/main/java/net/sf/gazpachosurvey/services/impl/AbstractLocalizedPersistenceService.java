package net.sf.gazpachosurvey.services.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Localizable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.LocalizedPersistenceService;
import net.sf.gazpachosurvey.types.Language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public abstract class AbstractLocalizedPersistenceService<L extends Localizable<LS, TR>, D extends IdentifiableLocalizable<LSD>, TR extends Translation<LS>, LS extends LanguageSettings, LSD extends LanguageSettings>
        extends AbstractPersistenceService<L, D> implements LocalizedPersistenceService<D, LSD> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractLocalizedPersistenceService.class);

    protected GenericRepository<TR> translationRepository;

    protected Class<TR> translationClazz;

    protected Class<LS> languageSettingsClazz;

    protected Class<LSD> languageSettingsDtoClazz;

    protected TranslationBuilder<TR, LS> translationBuilder;

    protected AbstractLocalizedPersistenceService(GenericRepository<L> repository,
            GenericRepository<TR> translationRepository, Class<L> entityClazz, Class<D> dtoClazz,
            Class<TR> translationClazz, Class<LS> languageSettingsClazz, Class<LSD> languageSettingsDtoClazz,
            TranslationBuilder<TR, LS> translationBuilder) {
        super(repository, entityClazz, dtoClazz);
        this.translationRepository = translationRepository;
        this.translationClazz = translationClazz;
        this.languageSettingsClazz = languageSettingsClazz;
        this.languageSettingsDtoClazz = languageSettingsDtoClazz;
        this.translationBuilder = translationBuilder;
    }

    @Override
    public D findOne(Integer id, Language language) {
        L entity = super.repository.findOne(id);
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
        D dto = mapper.map(entity, dtoClazz);
        dto.setLanguage(language);
        LSD languageSettingsDTO = mapper.map(languageSettings, languageSettingsDtoClazz);
        dto.setLanguageSettings(languageSettingsDTO);
        return dto;
    }

    @Override
    public void saveTranslation(Integer entityId, Language language, LSD languageSettingsDTO) {
        Assert.notNull(language, "Language is required");
        Assert.notNull(language, "EntityId is required");
        L entity = repository.findOne(entityId);
        TR translation = entity.getTranslations().get(language);
        if (translation == null) {
            translation = BeanUtils.instantiate(translationClazz);
            translation.setLanguage(language);
            entity.addTranslation(language, translation);
        }
        LS languageSettings = mapper.map(languageSettingsDTO, languageSettingsClazz);
        translation.setLanguageSettings(languageSettings);
        translationRepository.save(translation);
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

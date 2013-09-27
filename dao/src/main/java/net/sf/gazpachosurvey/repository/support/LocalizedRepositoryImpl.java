package net.sf.gazpachosurvey.repository.support;

import java.util.Map;

import javax.persistence.EntityManager;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.domain.support.Localizable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.util.Assert;

public class LocalizedRepositoryImpl<L extends Localizable<LS, TR>, LS extends LanguageSettings, TR extends Translation<LS>>
        extends GenericRepositoryImpl<L> implements LocalizedRepository<L> {

    private static final Logger logger = LoggerFactory.getLogger(LocalizedRepositoryImpl.class);

    public LocalizedRepositoryImpl(JpaEntityInformation<L, ?> entityInformation, EntityManager entityManager,
            ByExampleSpecification byExampleSpecification, NamedQueryUtil namedQueryUtil) {
        super(entityInformation, entityManager, byExampleSpecification, namedQueryUtil);
    }

    @Override
    public L findOne(Integer id, Language language) {
        L entity = findOne(id);
        Assert.notNull(language, "Language is required");
        
        if (entity == null){
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
        entity.setLanguageSettings(languageSettings);
        entity.setLanguage(language);
        return entity;
    }
}

package net.sf.gazpachosurvey.velocity.loader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;
import net.sf.gazpachosurvey.repository.i18.MailMessageTemplateTranslationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.types.Language;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalizedTemplateResourceLoaderImpl extends ResourceLoader implements LocalizedTemplateResourceLoader {

    private static final Logger logger = LoggerFactory.getLogger(LocalizedTemplateResourceLoaderImpl.class);

    private static final Pattern SOURCE_NAME_PATTERN = Pattern.compile("^(?<templateId>\\d+)(/(?<language>[a-z]+))?$",
            Pattern.CASE_INSENSITIVE);

    @Autowired
    private MailMessageTemplateRepository templateRepository;

    @Autowired
    private MailMessageTemplateTranslationRepository translationRepository;

    /**
     * @see org.apache.velocity.runtime.resource.loader.ResourceLoader#getLastModified(org.apache.velocity.runtime.resource.Resource)
     */
    @Override
    public long getLastModified(final Resource resource) {
        return readLastModified(resource, "getting timestamp");
    }

    @Override
    public InputStream getResourceStream(final String templateName) throws ResourceNotFoundException {
        Integer templateId = readTemplateId(templateName);
        Language language = readTemplateLanguage(templateName);

        MailMessageTemplateLanguageSettings languageSettings = readLanguageSettings(templateId, language);
        if (languageSettings == null) {
            throw new ResourceNotFoundException("Template not found");
        }
        return new ByteArrayInputStream(languageSettings.getBody().getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public void init(final ExtendedProperties configuration) {
    }

    @Override
    public boolean isCachingOn() {
        return true;
    }

    @Override
    public boolean isSourceModified(final Resource resource) {
        return resource.getLastModified() != readLastModified(resource, "checking timestamp");
    }

    protected Integer readTemplateId(final String templateName) {
        if (StringUtils.isEmpty(templateName)) {
            throw new ResourceNotFoundException("DataSourceResourceLoader: Template name was empty or null");
        }
        Matcher matcher = SOURCE_NAME_PATTERN.matcher(templateName);
        Integer templateId = null;
        if (matcher.matches()) {
            templateId = Integer.valueOf(matcher.group("templateId"));
        } else {
            throw new ResourceNotFoundException("Template name not valid. Pattern: templateId(/lang)?");
        }
        return templateId;
    }

    protected Language readTemplateLanguage(final String templateName) {
        if (StringUtils.isEmpty(templateName)) {
            throw new ResourceNotFoundException("DataSourceResourceLoader: Template name was empty or null");
        }
        Matcher matcher = SOURCE_NAME_PATTERN.matcher(templateName);
        String languageStr = null;
        if (matcher.matches()) {
            languageStr = matcher.group("language");
        } else {
            throw new ResourceNotFoundException("Template name not valid. Pattern: templateId(/lang)?");
        }

        Language language = null;
        if (StringUtils.isNotBlank(languageStr)) {
            language = Language.valueOf(languageStr);
            if (language == null) {
                throw new ResourceNotFoundException("Language not supported");
            }
        }
        return language;
    }

    private MailMessageTemplateLanguageSettings readLanguageSettings(final Integer templateId, final Language language) {
        MailMessageTemplateLanguageSettings languageSettings = null;
        MailMessageTemplate template = templateRepository.findOne(templateId);
        if (template != null) {
            if (template.getLanguage().equals(language)) {
                languageSettings = template.getLanguageSettings();
            } else {
                MailMessageTemplateTranslation example = new MailMessageTemplateTranslation();
                example.setLanguage(language);
                example.setMailMessageTemplate(MailMessageTemplate.with().id(templateId).build());
                List<MailMessageTemplateTranslation> translations = translationRepository.findByExample(example,
                        new SearchParameters());
                if (translations != null && !translations.isEmpty()) {
                    languageSettings = translations.get(0).getLanguageSettings();
                } else {
                    languageSettings = template.getLanguageSettings();
                    logger.warn("No translation in " + language
                            + " for MailMessageTemplate {}, providing default language", templateId);
                }
            }
        }
        return languageSettings;
    }

    private long readLastModified(final Resource resource, final String operation) {

        String templateName = resource.getName();
        Integer templateId = readTemplateId(templateName);
        logger.info("{} from mail message template {} ", operation, templateId);
        MailMessageTemplate template = templateRepository.findOne(templateId);
        return template.getLastModifiedDate().getMillis();
    }

}

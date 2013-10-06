package net.sf.gazpachosurvey.velocity.loader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;
import net.sf.gazpachosurvey.types.Language;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalizedTemplateResourceLoaderImpl extends ResourceLoader implements LocalizedTemplateResourceLoader{

    private static final Pattern SOURCE_NAME_PATTERN =  Pattern.compile("^(?<templateId>\\d+)(/(?<language>[a-z]+))?$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private MailMessageTemplateRepository templateRepository;
    
    @Override
    public void init(ExtendedProperties configuration) {
    }

    @Override
    public InputStream getResourceStream(String source)
            throws ResourceNotFoundException {
        if (StringUtils.isEmpty(source))
        {
            throw new ResourceNotFoundException("DataSourceResourceLoader: Template name was empty or null");
        }
        
        Matcher matcher = SOURCE_NAME_PATTERN.matcher(source);
        Integer templateId = null;
        String languageStr = null;
        if (matcher.matches()){
            templateId =  Integer.valueOf(matcher.group("templateId"));
            languageStr = matcher.group("language");
        }else{
            throw new ResourceNotFoundException("Template name not valid. Pattern: templateId(/lang)?");
        }
       
        MailMessageTemplate template = templateRepository.findOne(templateId);;
        if (StringUtils.isNotBlank(languageStr)){
            Language language = Language.valueOf(languageStr);
            if (language == null){
                throw new ResourceNotFoundException("Language not supported");
            }
            template = findOne(templateId, language);
        }
    
        if (template == null ){
            throw new ResourceNotFoundException("Template not found");
        }
        return new ByteArrayInputStream(template.getLanguageSettings().getBody().getBytes());
    }

    private MailMessageTemplate findOne(Integer templateId, Language language) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSourceModified(Resource resource) {
        return false;
    }

    @Override
    public long getLastModified(Resource resource) {
        return System.currentTimeMillis();
    }

}

package net.sf.gazpachosurvey.velocity.loader;

import java.io.InputStream;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.repository.MailMessageTemplateRepository;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalizedTemplateResourceLoader extends ResourceLoader{

    @Autowired
    MailMessageTemplateRepository templateRepository;
    
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

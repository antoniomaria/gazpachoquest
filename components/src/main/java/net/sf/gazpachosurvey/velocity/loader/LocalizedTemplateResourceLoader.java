package net.sf.gazpachosurvey.velocity.loader;

import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.runtime.resource.Resource;

public interface LocalizedTemplateResourceLoader {
    void init(ExtendedProperties configuration);

    InputStream getResourceStream(String source);

    boolean isSourceModified(Resource resource);

    long getLastModified(Resource resource);

}

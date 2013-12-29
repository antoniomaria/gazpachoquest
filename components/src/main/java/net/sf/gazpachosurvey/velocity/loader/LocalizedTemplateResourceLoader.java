package net.sf.gazpachosurvey.velocity.loader;

import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.runtime.resource.Resource;

public interface LocalizedTemplateResourceLoader {
    long getLastModified(Resource resource);

    InputStream getResourceStream(String source);

    void init(ExtendedProperties configuration);

    boolean isSourceModified(Resource resource);

}

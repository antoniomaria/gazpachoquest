/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.velocity.loader;

import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.runtime.resource.Resource;

public interface LocalizedTemplateResourceLoader {
    long getLastModified(Resource resource);

    InputStream getResourceStream(String source);

    void init(ExtendedProperties configuration);

    boolean isSourceModified(Resource resource);

}

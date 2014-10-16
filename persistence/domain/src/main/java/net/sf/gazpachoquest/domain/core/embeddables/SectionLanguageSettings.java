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
package net.sf.gazpachoquest.domain.core.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class SectionLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -3294430575682341044L;
    
    @Lob
    private String title;

    @Lob
    private String description;

    public SectionLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

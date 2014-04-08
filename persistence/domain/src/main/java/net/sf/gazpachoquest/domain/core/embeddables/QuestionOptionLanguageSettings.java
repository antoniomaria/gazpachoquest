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

import net.sf.gazpachoquest.domain.support.LanguageSettings;

@Embeddable
public class QuestionOptionLanguageSettings implements LanguageSettings {

    private static final long serialVersionUID = -7084726194267373517L;

    @Column(nullable = false)
    private String title;

    public QuestionOptionLanguageSettings() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

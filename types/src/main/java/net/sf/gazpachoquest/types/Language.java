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
package net.sf.gazpachoquest.types;

import java.util.Locale;

public enum Language {
    EN, ES, FI, FR;

    public static Language fromLocale(Locale locale) {
        for (Language language : Language.values()) {
            if (language.name().equalsIgnoreCase(locale.getLanguage())) {
                return language;
            }
        }
        return null;
    }
}

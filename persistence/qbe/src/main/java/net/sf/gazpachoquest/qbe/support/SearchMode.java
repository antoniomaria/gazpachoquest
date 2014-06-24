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
/*
 * Copyright 2012 JAXIO http://www.jaxio.com Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package net.sf.gazpachoquest.qbe.support;

/**
 * Static values to use in conjunction with {@link SearchParameters} object. It
 * maps the kind of search you can do in
 * SQL.
 */
public enum SearchMode {
    /**
     * Activates LIKE search and add a '%' prefix and suffix before searching.
     */
    ANYWHERE("any"),
    /**
     * Activate LIKE search and add a '%' suffix before searching.
     */
    ENDING_LIKE("el"),
    /**
     * Match exactly the properties
     */
    EQUALS("eq"),
    /**
     * Activate LIKE search. Manager provides the wildcard.
     */
    LIKE("li"),
    /**
     * Activate LIKE search and add a '%' prefix before searching.
     */
    STARTING_LIKE("sl");

    public static final SearchMode convert(final String code) {
        for (SearchMode searchMode : SearchMode.values()) {
            if (searchMode.getCode().equals(code)) {
                return searchMode;
            }
        }

        return EQUALS; // default
    }

    private final String code;

    SearchMode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

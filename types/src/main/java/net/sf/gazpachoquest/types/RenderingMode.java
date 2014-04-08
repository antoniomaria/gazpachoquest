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

public enum RenderingMode {

    QUESTION_BY_QUESTION("QUESTION_BY_QUESTION"), GROUP_BY_GROUP("GROUP_BY_GROUP");

    private final String value;

    RenderingMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RenderingMode fromString(String value) {
        for (RenderingMode c : RenderingMode.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value.toString());
    }
}

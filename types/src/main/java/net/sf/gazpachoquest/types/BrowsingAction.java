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

public enum BrowsingAction {
    FORWARD("FORWARD"), BACKWARD("BACKWARD"), ENTERING("ENTERING");

    private final String value;

    BrowsingAction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static BrowsingAction fromString(String value) {
        for (BrowsingAction c : BrowsingAction.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value.toString());
    }
}

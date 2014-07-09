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

public enum EntityStatus {
    DRAFT("D"), CONFIRMED("C");
    private String code;

    EntityStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static EntityStatus fromCode(String code) {
        for (EntityStatus status : EntityStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status " + code.toString() + " not supported");
    }

}

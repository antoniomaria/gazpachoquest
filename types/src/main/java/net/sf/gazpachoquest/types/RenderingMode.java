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

    QUESTION_BY_QUESTION("QBQ"), SECTION_BY_SECTION("SBS"), ALL_IN_ONE("AIO");

    private final String code;

    RenderingMode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static RenderingMode fromCode(String code) {
        for (RenderingMode renderingMode : RenderingMode.values()) {
            if (renderingMode.getCode().equals(code)) {
                return renderingMode;
            }
        }
        throw new IllegalArgumentException(String.format("RenderingMode code %s not supported", code));
    }

    public static RenderingMode fromValue(String value) {
        for (RenderingMode renderingMode : RenderingMode.values()) {
            if (renderingMode.toString().equals(value)) {
                return renderingMode;
            }
        }
        throw new IllegalArgumentException(String.format("RenderingMode value %s not supported", value));
    }
}

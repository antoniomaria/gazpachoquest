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
package net.sf.gazpachoquest.dto.answers;

public class TextAnswer extends SimpleAnswer {

    private static final long serialVersionUID = 672728157327871902L;

    private String value;

    public TextAnswer() {
        super();
    }

    public TextAnswer(String value) {
        super();
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static TextAnswer fromValue(String value) {
        return new TextAnswer(value);
    }

    @Override
    public String toString() {
        return "TextAnswer [value=" + value + "]";
    }

}

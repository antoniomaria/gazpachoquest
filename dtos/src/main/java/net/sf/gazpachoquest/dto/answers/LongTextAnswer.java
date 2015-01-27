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

import org.apache.commons.lang3.ArrayUtils;

@SuppressWarnings("serial")
public class LongTextAnswer extends SimpleAnswer {

    private String value;

    public LongTextAnswer() {
        super();
    }

    public LongTextAnswer(String value) {
        super();
        this.value = value;
    }

    @Override
    public Character[] getValue() {
        return ArrayUtils.toObject(value.toCharArray());
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static LongTextAnswer fromValue(String value) {
        return new LongTextAnswer(value);
    }

    @Override
    public String toString() {
        return "LongTextAnswer [value=" + value + "]";
    }

}

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

@SuppressWarnings("serial")
public class NumericAnswer extends SimpleAnswer {

    private Integer value;

    public NumericAnswer() {
        super();
    }

    public NumericAnswer(Integer value) {
        super();
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static NumericAnswer fromValue(Integer value) {
        return new NumericAnswer(value);
    }

    @Override
    public String toString() {
        return "NumericAnswer [value=" + value + "]";
    }

}

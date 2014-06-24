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

import org.apache.commons.lang3.BooleanUtils;

public class BooleanAnswer extends SimpleAnswer {

    private static final long serialVersionUID = -6283418338635814499L;

    private String option;

    private Boolean value;

    public BooleanAnswer() {
        super();
    }

    public BooleanAnswer(String option, boolean value) {
        this();
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public static BooleanAnswer valueOf(String option, Boolean value) {
        return new BooleanAnswer(option, BooleanUtils.toBoolean(value));
    }

    @Override
    public String toString() {
        return "BooleanAnswer [option=" + option + ", value=" + value + "]";
    }

}

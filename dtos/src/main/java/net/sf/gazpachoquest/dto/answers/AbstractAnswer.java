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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = TextAnswer.class, name = "T"),
        @JsonSubTypes.Type(value = NumericAnswer.class, name = "N"),
        @JsonSubTypes.Type(value = BooleanAnswer.class, name = "B"),
        @JsonSubTypes.Type(value = MultipleAnswer.class, name = "M"),
        @JsonSubTypes.Type(value = LongTextAnswer.class, name = "L"),
        @JsonSubTypes.Type(value = BlankAnswer.class, name = "NULL")})
public abstract class AbstractAnswer implements Answer {

    private static final long serialVersionUID = -2678283968130774295L;

    protected AbstractAnswer() {
        super();
    }

    @Override
    public abstract Object getValue();
}

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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @composed - has 1..* SimpleAnswer
 */
@SuppressWarnings("serial")
public class MultipleAnswer extends AbstractAnswer {

    private List<Answer> answers = new ArrayList<>();

    public MultipleAnswer() {
        super();
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "MultipleAnswer [answers=" + answers + "]";
    }

    @Override
    @JsonIgnore
    public Object getValue() {
        throw new UnsupportedOperationException();
    }

}

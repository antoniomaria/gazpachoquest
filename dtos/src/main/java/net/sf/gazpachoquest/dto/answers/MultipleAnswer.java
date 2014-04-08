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

//import org.codehaus.jackson.annotate.JsonIgnore;

public class MultipleAnswer extends AbstractAnswer {

    private static final long serialVersionUID = -2399910856085158733L;

    private List<Answer> answers;

    public MultipleAnswer() {
        super();
        answers = new ArrayList<>();
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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

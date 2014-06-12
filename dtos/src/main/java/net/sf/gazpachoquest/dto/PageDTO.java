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
package net.sf.gazpachoquest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageDTO implements Serializable {

    private static final long serialVersionUID = -4722536148236589317L;

    private final List<QuestionDTO> questions = new ArrayList<>();

    private PageMetadataDTO metadata;

    public PageDTO() {
        super();
    }

    public void addQuestion(QuestionDTO question) {
        questions.add(question);
    }

    public List<QuestionDTO> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public PageMetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(PageMetadataDTO metadata) {
        this.metadata = metadata;
    }

}

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

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuestionnairPageDTO implements Serializable {

    private static final long serialVersionUID = -4722536148236589317L;

    private final List<QuestionGroupDTO> questionGroups = new ArrayList<>();

    private PageMetadataDTO metadata;

    public QuestionnairPageDTO() {
        super();
    }

    public void addQuestionGroup(QuestionGroupDTO questionGroup) {
        questionGroups.add(questionGroup);
    }

    public List<QuestionGroupDTO> getQuestionGroups() {
        return Collections.unmodifiableList(questionGroups);
    }

    public PageMetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(PageMetadataDTO metadata) {
        this.metadata = metadata;
    }

    @JsonIgnore
    public List<QuestionDTO> getQuestions() {
        List<QuestionDTO> allQuestions = new ArrayList<>();
        for (QuestionGroupDTO questionGroup : questionGroups) {
            List<QuestionDTO> questions = questionGroup.getQuestions();
            allQuestions.addAll(questions);
        }
        return allQuestions;
    }

}

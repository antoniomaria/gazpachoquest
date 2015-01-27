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

@SuppressWarnings("serial")
public class QuestionnairePageDTO implements Serializable {

    private final List<SectionDTO> sections = new ArrayList<>();

    private PageMetadataDTO metadata;

    private boolean sectionInfoAvailable;

    public QuestionnairePageDTO() {
        super();
    }

    public void addSection(SectionDTO section) {
        sections.add(section);
    }

    public List<SectionDTO> getSections() {
        return Collections.unmodifiableList(sections);
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
        for (SectionDTO section : sections) {
            List<QuestionDTO> questions = section.getQuestions();
            allQuestions.addAll(questions);
        }
        return allQuestions;
    }

    public boolean isSectionInfoAvailable() {
        return sectionInfoAvailable;
    }

    public void setSectionInfoAvailable(boolean sectionInfoAvailable) {
        this.sectionInfoAvailable = sectionInfoAvailable;
    }

}

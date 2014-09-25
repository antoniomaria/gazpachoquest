/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.joda.time.DateTime;

public class ResearchDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -8624509103476946501L;

    private DateTime expirationDate;

    private String name;

    private final Set<UserDTO> respondents = new HashSet<>();

    private DateTime startDate;

    private QuestionnaireDefinitionDTO questionnaireDefinition;

    private ResearchAccessType type;

    public ResearchDTO() {
        super();
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public void addRespondent(UserDTO userDTO) {
        respondents.add(userDTO);
    }

    public Set<UserDTO> getRespondents() {
        return Collections.unmodifiableSet(respondents);
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public ResearchAccessType getType() {
        return type;
    }

    public void setExpirationDate(final DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(final ResearchAccessType type) {
        this.type = type;
    }

    public QuestionnaireDefinitionDTO getQuestionnaireDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnaireDefinition(QuestionnaireDefinitionDTO questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private DateTime expirationDate;
        private String name;
        private DateTime startDate;
        private ResearchAccessType type;
        private QuestionnaireDefinitionDTO questionnaireDefinition;

        public Builder questionnaireDefinition(QuestionnaireDefinitionDTO questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
            return this;
        }

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startDate(DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder type(ResearchAccessType type) {
            this.type = type;
            return this;
        }

        public ResearchDTO build() {
            ResearchDTO researchDTO = new ResearchDTO();
            researchDTO.expirationDate = expirationDate;
            researchDTO.name = name;
            researchDTO.startDate = startDate;
            researchDTO.type = type;
            researchDTO.questionnaireDefinition = questionnaireDefinition;
            return researchDTO;
        }
    }
}

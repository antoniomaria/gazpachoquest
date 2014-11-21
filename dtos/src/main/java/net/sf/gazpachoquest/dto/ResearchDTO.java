/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import java.time.LocalDateTime;

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.types.ResearchAccessType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


public class ResearchDTO extends AbstractAuditableDTO {

    private static final long serialVersionUID = -8624509103476946501L;
    
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expirationDate;

    private String name;
    
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    private QuestionnaireDefinitionDTO questionnaireDefinition;

    private ResearchAccessType type;

    public ResearchDTO() {
        super();
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public ResearchAccessType getType() {
        return type;
    }

    public void setExpirationDate(final LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setStartDate(final LocalDateTime startDate) {
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
        private Integer id;
        private LocalDateTime expirationDate;
        private String name;
        private LocalDateTime startDate;
        private ResearchAccessType type;
        private QuestionnaireDefinitionDTO questionnaireDefinition;

        public Builder questionnaireDefinition(QuestionnaireDefinitionDTO questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
            return this;
        }

        public Builder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
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
            researchDTO.setId(id);
            return researchDTO;
        }
    }
}

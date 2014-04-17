/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.StudyAccessType;

import org.joda.time.DateTime;

public class StudyDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -8624509103476946501L;

    private DateTime expirationDate;

    private String name;

    private Set<UserDTO> respondents;

    private DateTime startDate;

    private Set<QuestionnairDefinitionDTO> questionnairDefinitions;

    private StudyAccessType type;

    public StudyDTO() {
        super();
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Set<UserDTO> getRespondents() {
        if (this.respondents == null) {
            this.respondents = new HashSet<>();
        }
        return respondents;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public StudyAccessType getType() {
        return type;
    }

    public void setExpirationDate(final DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setRespondents(final Set<UserDTO> respondents) {
        this.respondents = respondents;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(final StudyAccessType type) {
        this.type = type;
    }

    public Set<QuestionnairDefinitionDTO> getQuestionnairDefinitions() {
        return questionnairDefinitions;
    }

    public void setQuestionnairDefinitions(Set<QuestionnairDefinitionDTO> questionnairDefinition) {
        this.questionnairDefinitions = questionnairDefinition;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private DateTime expirationDate;
        private String name;
        private Set<UserDTO> respondents;
        private DateTime startDate;
        private Set<QuestionnairDefinitionDTO> questionnairDefinitions;
        private StudyAccessType type;

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder respondents(Set<UserDTO> respondents) {
            this.respondents = respondents;
            return this;
        }

        public Builder startDate(DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder questionnairDefinitions(Set<QuestionnairDefinitionDTO> questionnairDefinitions) {
            this.questionnairDefinitions = questionnairDefinitions;
            return this;
        }

        public Builder type(StudyAccessType type) {
            this.type = type;
            return this;
        }

        public StudyDTO build() {
            StudyDTO studyDTO = new StudyDTO();
            studyDTO.expirationDate = expirationDate;
            studyDTO.name = name;
            studyDTO.respondents = respondents;
            studyDTO.startDate = startDate;
            studyDTO.questionnairDefinitions = questionnairDefinitions;
            studyDTO.type = type;
            return studyDTO;
        }
    }
}

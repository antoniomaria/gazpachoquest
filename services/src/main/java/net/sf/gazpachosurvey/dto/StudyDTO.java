package net.sf.gazpachosurvey.dto;

import java.util.Set;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.SurveyInstanceType;

import org.joda.time.DateTime;

public class StudyDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -8624509103476946501L;

    private DateTime expirationDate;

    private String name;

    private Set<ParticipantDTO> participants;

    private DateTime startDate;

    private Set<QuestionnairDefinitionDTO> questionnairDefinitions;

    private SurveyInstanceType type;

    public StudyDTO() {
        super();
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Set<ParticipantDTO> getParticipants() {
        return participants;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public SurveyInstanceType getType() {
        return type;
    }

    public void setExpirationDate(final DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setParticipants(final Set<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    public void setType(final SurveyInstanceType type) {
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
        private Set<ParticipantDTO> participants;
        private DateTime startDate;
        private Set<QuestionnairDefinitionDTO> questionnairDefinitions;
        private SurveyInstanceType type;

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder participants(Set<ParticipantDTO> participants) {
            this.participants = participants;
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

        public Builder type(SurveyInstanceType type) {
            this.type = type;
            return this;
        }

        public StudyDTO build() {
            StudyDTO studyDTO = new StudyDTO();
            studyDTO.expirationDate = expirationDate;
            studyDTO.name = name;
            studyDTO.participants = participants;
            studyDTO.startDate = startDate;
            studyDTO.questionnairDefinitions = questionnairDefinitions;
            studyDTO.type = type;
            return studyDTO;
        }
    }
}

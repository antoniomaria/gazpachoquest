package net.sf.gazpachosurvey.dto;

import java.util.Set;

import net.sf.gazpachosurvey.types.SurveyRunningType;

import org.joda.time.DateTime;

public class SurveyRunningDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -8624509103476946501L;

    private SurveyDTO survey;
    
    private String name;

    private SurveyRunningType type;

    private DateTime startDate;

    private DateTime expirationDate;

    private Set<ParticipantDTO> participants;

    public SurveyRunningDTO() {
        super();
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public SurveyRunningType getType() {
        return type;
    }

    public void setType(SurveyRunningType type) {
        this.type = type;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private SurveyDTO survey;
        private String name;
        private SurveyRunningType type;
        private DateTime startDate;
        private DateTime expirationDate;
        private Set<ParticipantDTO> participants;

        public Builder survey(SurveyDTO survey) {
            this.survey = survey;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(SurveyRunningType type) {
            this.type = type;
            return this;
        }

        public Builder startDate(DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expirationDate(DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder participants(Set<ParticipantDTO> participants) {
            this.participants = participants;
            return this;
        }

        public SurveyRunningDTO build() {
            SurveyRunningDTO surveyRunningDTO = new SurveyRunningDTO();
            surveyRunningDTO.survey = survey;
            surveyRunningDTO.name = name;
            surveyRunningDTO.type = type;
            surveyRunningDTO.startDate = startDate;
            surveyRunningDTO.expirationDate = expirationDate;
            surveyRunningDTO.participants = participants;
            return surveyRunningDTO;
        }
    }
}

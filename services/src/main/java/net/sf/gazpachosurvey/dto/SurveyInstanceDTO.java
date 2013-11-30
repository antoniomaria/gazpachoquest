package net.sf.gazpachosurvey.dto;

import java.util.Set;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.SurveyInstanceType;

import org.joda.time.DateTime;

public class SurveyInstanceDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -8624509103476946501L;

    private SurveyDTO survey;

    private String name;

    private SurveyInstanceType type;

    private DateTime startDate;

    private DateTime expirationDate;

    private Set<ParticipantDTO> participants;

    public SurveyInstanceDTO() {
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

    public SurveyInstanceType getType() {
        return type;
    }

    public void setType(SurveyInstanceType type) {
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
        private SurveyInstanceType type;
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

        public Builder type(SurveyInstanceType type) {
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

        public SurveyInstanceDTO build() {
            SurveyInstanceDTO surveyInstanceDTO = new SurveyInstanceDTO();
            surveyInstanceDTO.survey = survey;
            surveyInstanceDTO.name = name;
            surveyInstanceDTO.type = type;
            surveyInstanceDTO.startDate = startDate;
            surveyInstanceDTO.expirationDate = expirationDate;
            surveyInstanceDTO.participants = participants;
            return surveyInstanceDTO;
        }
    }
}

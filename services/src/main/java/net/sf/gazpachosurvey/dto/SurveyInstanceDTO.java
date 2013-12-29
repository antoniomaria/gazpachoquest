package net.sf.gazpachosurvey.dto;

import java.util.Set;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.SurveyInstanceType;

import org.joda.time.DateTime;

public class SurveyInstanceDTO extends AbstractIdentifiableDTO {

    public static class Builder {
        private DateTime expirationDate;
        private String name;
        private Set<ParticipantDTO> participants;
        private DateTime startDate;
        private SurveyDTO survey;
        private SurveyInstanceType type;

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

        public Builder expirationDate(final DateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder participants(final Set<ParticipantDTO> participants) {
            this.participants = participants;
            return this;
        }

        public Builder startDate(final DateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder survey(final SurveyDTO survey) {
            this.survey = survey;
            return this;
        }

        public Builder type(final SurveyInstanceType type) {
            this.type = type;
            return this;
        }
    }

    private static final long serialVersionUID = -8624509103476946501L;

    public static Builder with() {
        return new Builder();
    }

    private DateTime expirationDate;

    private String name;

    private Set<ParticipantDTO> participants;

    private DateTime startDate;

    private SurveyDTO survey;

    private SurveyInstanceType type;

    public SurveyInstanceDTO() {
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

    public SurveyDTO getSurvey() {
        return survey;
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

    public void setSurvey(final SurveyDTO survey) {
        this.survey = survey;
    }

    public void setType(final SurveyInstanceType type) {
        this.type = type;
    }
}

package net.sf.gazpachosurvey.dto;

import java.util.Date;
import java.util.Set;

import net.sf.gazpachosurvey.types.SurveyRunningType;

public class SurveyRunningDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = -8624509103476946501L;

    private String name;

    private SurveyRunningType type;

    private Date startDate;

    private Date expirationDate;

    private Set<ParticipantDTO> participants;

    public SurveyRunningDTO() {
        super();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private SurveyRunningType type;
        private Date startDate;
        private Date expirationDate;
        private Set<ParticipantDTO> participants;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(SurveyRunningType type) {
            this.type = type;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder participants(Set<ParticipantDTO> participants) {
            this.participants = participants;
            return this;
        }

        public SurveyRunningDTO build() {
            SurveyRunningDTO surveyRunningDTO = new SurveyRunningDTO();
            surveyRunningDTO.name = name;
            surveyRunningDTO.type = type;
            surveyRunningDTO.startDate = startDate;
            surveyRunningDTO.expirationDate = expirationDate;
            surveyRunningDTO.participants = participants;
            return surveyRunningDTO;
        }
    }
}

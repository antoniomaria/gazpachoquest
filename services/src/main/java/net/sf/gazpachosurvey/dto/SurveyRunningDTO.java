package net.sf.gazpachosurvey.dto;

import java.util.Set;

public class SurveyRunningDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = -8624509103476946501L;

    private String name;

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

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private Set<ParticipantDTO> participants;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder participants(Set<ParticipantDTO> participants) {
            this.participants = participants;
            return this;
        }

        public SurveyRunningDTO build() {
            SurveyRunningDTO surveyRunningDTO = new SurveyRunningDTO();
            surveyRunningDTO.name = name;
            surveyRunningDTO.participants = participants;
            return surveyRunningDTO;
        }
    }
}

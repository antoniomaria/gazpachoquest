package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.types.InvitationStatus;
import net.sf.gazpachosurvey.types.InvitationType;

public class InvitationDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -2776483997831033883L;

    private String token;

    private SurveyInstanceDTO surveyInstance;

    private InvitationStatus status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SurveyInstanceDTO getSurveyInstance() {
        return surveyInstance;
    }

    public void setSurveyInstance(SurveyInstanceDTO surveyInstance) {
        this.surveyInstance = surveyInstance;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        private InvitationType type;

        private SurveyInstanceDTO surveyInstance;
        private InvitationStatus status;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder surveyInstance(SurveyInstanceDTO surveyInstance) {
            this.surveyInstance = surveyInstance;
            return this;
        }

        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Builder type(InvitationType type) {
            this.type = type;
            return this;
        }

        public InvitationDTO build() {
            InvitationDTO invitationDTO = new InvitationDTO();
            invitationDTO.token = token;
            invitationDTO.surveyInstance = surveyInstance;
            invitationDTO.status = status;
            return invitationDTO;
        }
    }
}

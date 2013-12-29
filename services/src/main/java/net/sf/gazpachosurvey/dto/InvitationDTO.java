package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.InvitationStatus;
import net.sf.gazpachosurvey.types.InvitationType;

public class InvitationDTO extends AbstractIdentifiableDTO {

    public static class Builder {
        private InvitationStatus status;
        private SurveyInstanceDTO surveyInstance;

        private String token;
        private InvitationType type;

        public InvitationDTO build() {
            InvitationDTO invitationDTO = new InvitationDTO();
            invitationDTO.token = token;
            invitationDTO.surveyInstance = surveyInstance;
            invitationDTO.status = status;
            invitationDTO.type = type;
            return invitationDTO;
        }

        public Builder status(final InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Builder surveyInstance(final SurveyInstanceDTO surveyInstance) {
            this.surveyInstance = surveyInstance;
            return this;
        }

        public Builder token(final String token) {
            this.token = token;
            return this;
        }

        public Builder type(final InvitationType type) {
            this.type = type;
            return this;
        }
    }

    private static final long serialVersionUID = -2776483997831033883L;

    public static Builder with() {
        return new Builder();
    }

    private InvitationStatus status;

    private SurveyInstanceDTO surveyInstance;

    private String token;

    private InvitationType type;

    public InvitationStatus getStatus() {
        return status;
    }

    public SurveyInstanceDTO getSurveyInstance() {
        return surveyInstance;
    }

    public String getToken() {
        return token;
    }

    public InvitationType getType() {
        return type;
    }

    public void setStatus(final InvitationStatus status) {
        this.status = status;
    }

    public void setSurveyInstance(final SurveyInstanceDTO surveyInstance) {
        this.surveyInstance = surveyInstance;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setType(final InvitationType type) {
        this.type = type;
    }
}

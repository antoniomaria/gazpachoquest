package net.sf.gazpachosurvey.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.types.InvitationStatus;

@Entity
@DiscriminatorValue("P")
public class PersonalInvitation extends Invitation {

    private static final long serialVersionUID = -9203813369476903640L;

    @OneToOne(fetch = FetchType.LAZY)
    private Respondent respondent;

    public PersonalInvitation() {
        super();
    }

    public Respondent getRespondent() {
        return respondent;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }
public static Builder with(){
    return new Builder();
}
    public static class Builder {
        
        private String token;
        private SurveyRunning surveyRunning;
        private InvitationStatus status;
        private Respondent respondent;


        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder surveyRunning(SurveyRunning surveyRunning) {
            this.surveyRunning = surveyRunning;
            return this;
        }

        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }
        
        public Builder respondent(Respondent respondent) {
            this.respondent = respondent;
            return this;
        }

        public PersonalInvitation build() {
            return new PersonalInvitation(this);
        }
    }

    private PersonalInvitation(Builder builder) {
        super(builder.token, builder.surveyRunning, builder.status);
        this.respondent = builder.respondent;
    }
}

package net.sf.gazpachosurvey.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.types.InvitationStatus;
import net.sf.gazpachosurvey.domain.support.Invitation;

@Entity
@DiscriminatorValue("P")
public class PersonalInvitation extends Invitation {

    private static final long serialVersionUID = -9203813369476903640L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Participant participant;

    public PersonalInvitation() {
        super();
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder extends Invitation.Builder {

        private String token;
        private Study study;
        private InvitationStatus status;
        private Participant participant;

        @Override
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public Builder study(Study study) {
            this.study = study;
            return this;
        }

        public Builder participant(Participant participant) {
            this.participant = participant;
            return this;
        }

        @Override
        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public PersonalInvitation build() {
            return new PersonalInvitation(this);
        }
    }

    private PersonalInvitation(Builder builder) {
        super(builder.token, builder.study, builder.status);
        this.participant = builder.participant;
    }
}

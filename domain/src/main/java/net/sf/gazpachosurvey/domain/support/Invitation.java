package net.sf.gazpachosurvey.domain.support;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gazpachosurvey.domain.core.SurveyInstance;
import net.sf.gazpachosurvey.types.InvitationStatus;

@Entity
@Table(name = "invitation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Invitation extends AbstractPersistable {

    private static final long serialVersionUID = -9203813369476903640L;

    @Column(nullable = false)
    protected String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected SurveyInstance surveyInstance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected InvitationStatus status;

    public Invitation() {
        super();
    }

    protected Invitation(String token, SurveyInstance surveyInstance, InvitationStatus status) {
        super();
        this.token = token;
        this.surveyInstance = surveyInstance;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SurveyInstance getSurveyInstance() {
        return surveyInstance;
    }

    public void setSurveyInstance(SurveyInstance surveyInstance) {
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
        private Integer id;
        private String token;
        private SurveyInstance surveyInstance;
        private InvitationStatus status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder surveyInstance(SurveyInstance surveyInstance) {
            this.surveyInstance = surveyInstance;
            return this;
        }

        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Invitation build() {
            Invitation invitation = new Invitation();
            invitation.token = token;
            invitation.surveyInstance = surveyInstance;
            invitation.status = status;
            invitation.setId(id);
            return invitation;
        }
    }
}

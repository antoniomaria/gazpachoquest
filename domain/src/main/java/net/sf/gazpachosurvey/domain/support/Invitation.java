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

import net.sf.gazpachosurvey.domain.core.Study;
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
    protected Study study;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected InvitationStatus status;

    public Invitation() {
        super();
    }

    protected Invitation(String token, Study study, InvitationStatus status) {
        super();
        this.token = token;
        this.study = study;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Study getSurveyInstance() {
        return study;
    }

    public void setSurveyInstance(Study study) {
        this.study = study;
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
        private Study study;
        private InvitationStatus status;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder study(Study study) {
            this.study = study;
            return this;
        }

        public Builder status(InvitationStatus status) {
            this.status = status;
            return this;
        }

        public Invitation build() {
            Invitation invitation = new Invitation();
            invitation.token = token;
            invitation.study = study;
            invitation.status = status;
            invitation.setId(id);
            return invitation;
        }
    }
}

package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.InvitationStatus;

@Entity
public class Invitation extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = -9203813369476903640L;

    private String token;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyRunning surveyRunning;
    
    private InvitationStatus status;

    @OneToOne(fetch=FetchType.LAZY)
    private InvitationMessage message;
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SurveyRunning getSurveyRunning() {
        return surveyRunning;
    }

    public void setSurveyRunning(SurveyRunning surveyRunning) {
        this.surveyRunning = surveyRunning;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }
    
}

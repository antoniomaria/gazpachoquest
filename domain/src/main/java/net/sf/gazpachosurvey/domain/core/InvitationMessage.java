package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@Entity
public class InvitationMessage extends AbstractPersistable<Integer>{

    private static final long serialVersionUID = 2597367892321945501L;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="message")
    private Invitation invitation;
    
    private String destination;
    
    @Lob
    private String content;
    
    private Integer deliveryAttempts;
    
    private InvitationMessage() {
        super();
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDeliveryAttempts() {
        return deliveryAttempts;
    }

    public void setDeliveryAttempts(Integer deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
    }
    
    
}

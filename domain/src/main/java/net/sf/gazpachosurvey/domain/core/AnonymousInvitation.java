package net.sf.gazpachosurvey.domain.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import net.sf.gazpachosurvey.domain.support.AbstractInvitation;

@Entity
@DiscriminatorValue("A")
public class AnonymousInvitation extends AbstractInvitation{

    private static final long serialVersionUID = -9203813369476903640L;

    public AnonymousInvitation(){
        super();
    }

}

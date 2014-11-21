package net.sf.gazpachoquest.domain.support;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.types.InvitationStatus;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(Invitation.class)
public class Invitation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<Invitation, Research> research;
    public static volatile SingularAttribute<Invitation, String> token;
    public static volatile SingularAttribute<Invitation, InvitationStatus> status;

}
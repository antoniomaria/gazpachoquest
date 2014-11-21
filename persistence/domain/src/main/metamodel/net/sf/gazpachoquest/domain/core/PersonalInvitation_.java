package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.Invitation_;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(PersonalInvitation.class)
public class PersonalInvitation_ extends Invitation_ {

    public static volatile SingularAttribute<PersonalInvitation, User> respondent;

}
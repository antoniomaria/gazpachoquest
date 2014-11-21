package net.sf.gazpachoquest.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(Role.class)
public class Role_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<Role, String> name;
    public static volatile SingularAttribute<Role, String> description;
    public static volatile SetAttribute<Role, User> users;

}
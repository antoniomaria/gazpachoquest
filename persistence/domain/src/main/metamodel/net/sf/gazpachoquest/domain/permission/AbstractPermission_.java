package net.sf.gazpachoquest.domain.permission;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(AbstractPermission.class)
public class AbstractPermission_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<AbstractPermission, Role> role;
    public static volatile SingularAttribute<AbstractPermission, User> user;
    public static volatile SingularAttribute<AbstractPermission, Integer> mask;
    public static volatile SingularAttribute<AbstractPermission, ? extends Object> target;

}
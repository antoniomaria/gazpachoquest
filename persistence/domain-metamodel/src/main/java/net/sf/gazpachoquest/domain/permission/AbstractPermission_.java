package net.sf.gazpachoquest.domain.permission;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T16:48:29")
@StaticMetamodel(AbstractPermission.class)
public class AbstractPermission_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<AbstractPermission, ? extends Object> target;
    public static volatile SingularAttribute<AbstractPermission, Role> role;
    public static volatile SingularAttribute<AbstractPermission, Integer> mask;
    public static volatile SingularAttribute<AbstractPermission, User> user;

}
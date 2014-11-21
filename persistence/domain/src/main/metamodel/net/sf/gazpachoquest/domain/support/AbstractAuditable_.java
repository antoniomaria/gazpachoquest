package net.sf.gazpachoquest.domain.support;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(AbstractAuditable.class)
public abstract class AbstractAuditable_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<AbstractAuditable, LocalDateTime> createdDate;
    public static volatile SingularAttribute<AbstractAuditable, User> createdBy;
    public static volatile SingularAttribute<AbstractAuditable, LocalDateTime> lastModifiedDate;
    public static volatile SingularAttribute<AbstractAuditable, User> lastModifiedBy;

}
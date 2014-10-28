package net.sf.gazpachoquest.domain.support;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.user.User;
import org.joda.time.LocalDateTime;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-28T07:30:16")
@StaticMetamodel(AbstractAuditable.class)
public abstract class AbstractAuditable_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<AbstractAuditable, User> createdBy;
    public static volatile SingularAttribute<AbstractAuditable, User> lastModifiedBy;
    public static volatile SingularAttribute<AbstractAuditable, LocalDateTime> lastModifiedDate;
    public static volatile SingularAttribute<AbstractAuditable, LocalDateTime> createdDate;

}
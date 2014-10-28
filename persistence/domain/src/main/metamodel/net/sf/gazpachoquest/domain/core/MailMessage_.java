package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import org.joda.time.LocalDateTime;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-28T07:30:16")
@StaticMetamodel(MailMessage.class)
public class MailMessage_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<MailMessage, Integer> deliveryAttempts;
    public static volatile SingularAttribute<MailMessage, String> body;
    public static volatile SingularAttribute<MailMessage, String> replyTo;
    public static volatile SingularAttribute<MailMessage, String> subject;
    public static volatile SingularAttribute<MailMessage, LocalDateTime> sentDate;
    public static volatile SingularAttribute<MailMessage, String> fromAddress;
    public static volatile SingularAttribute<MailMessage, String> toAddress;

}